package socket.duoxiancheng;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Created by Administrator on 2017/7/3 0003.
 * 服务器端Socket
 */
public class ServerSocketMany {
        /**
         * main测试方法
         * @param args
         * @throws IOException
         */
        public static void main(String[] args) throws IOException {

            System.out.println("服务器已经启动，等待客户端的连接....");

            //创建服务器端Socket，即ServerSOcket，等待客户端的请求
            ServerSocket server = new ServerSocket(5555);

            int count = 0;//侦听到的客户端的数量

            Socket socket = null;//服务器端Socket

            //死循环，让服务端循环侦听
            while(true){

                //服务端开始侦听客户端的连接
                socket = server.accept();

                //启动线程，与客户端进行通信
                Thread serverThread = new ServerThread(socket);
                serverThread.start();

                //计数，统计客户端连接数
                count++;

                System.out.println("当前链接的客户端的数量为："+count+"个....");
            }
        }
}

