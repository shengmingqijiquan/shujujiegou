package socket.duoxiancheng;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Administrator on 2017/7/3 0003.
 */
public class ClientSocketDemo {
    /**
     * main测试方法
     * @param args
     * @throws UnknownHostException
     * @throws IOException
     */
    public static void main(String[] args) throws UnknownHostException, IOException {

        //创建客户端Socket，向服务器发起请求
//      String address = "127.0.0.1";
        String address = "localhost";//服务器地址

        int port = 5555;//端口号
        Socket socket = new Socket(address, port);

        //获取Socket的字节输出流
        OutputStream out = socket.getOutputStream();

        //将字节输出流包装成字符打印输出流
        PrintWriter pw = new PrintWriter(out);

//      pw.print("用户名：admin,密码：123");
//      pw.print("用户名：tom,密码：456");
//      pw.print("用户名：dark,密码：789");
//      pw.print("用户名：white,密码：111");
        pw.print("用户名：green,密码：222");

        //刷新输出流
        pw.flush();

        //调用shutDown方法关闭Socket的输出流
        socket.shutdownOutput();

        //接收服务器端发来的响应信息，获取字节输入流
        InputStream in = socket.getInputStream();

        //将字节输入流包装成字符输入流
        InputStreamReader isr = new InputStreamReader(in);

        //为字符输入流添加缓冲
        BufferedReader br = new BufferedReader(isr);

        //读取字符输入流中的数据信息
        String data = null;
        while((data = br.readLine()) != null){
            System.out.println("我是客户端，服务器说："+data);
        }

        //调用shutDown方法关闭Socket的输入流
        socket.shutdownInput();

        br.close();
        isr.close();
        in.close();
        pw.close();
        out.close();
        socket.close();
    }
}
