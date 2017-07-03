package socket.duoxiancheng;

import java.io.*;
import java.net.Socket;

/**
 * Created by Administrator on 2017/7/3 0003.
 */
public class ServerThread extends Thread {
    //每当侦听到一个新的客户端的时，服务端这边都要有一个Socket与之进行通信
    public Socket socket = null;

    //默认的构造方法，保留
    public ServerThread() {
    }

    //带参构造方法
    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    //覆写run方法
    public void run() {
        //获取输入字节流
        InputStream in = null;

        //将输入字节流包装成输入字符流
        InputStreamReader isr = null;

        //为字符输入流添加缓冲
        BufferedReader br = null;

        //收到信息之后，向客户端响应信息,获取输出字节流
        OutputStream out = null;

        //将字节输出流包装成字符打印输出流
        PrintWriter pw = null;

        try {

            in = socket.getInputStream();
            isr = new InputStreamReader(in);
            br = new BufferedReader(isr);

            //读取字符输入流中的数据
            String data = null;
            while ((data = br.readLine()) != null) {
                System.out.println("我是服务器，客户端说：" + data);
            }

            //调用shutDown方法关闭Socket输入流
            socket.shutdownInput();

            out = socket.getOutputStream();
            pw = new PrintWriter(out);
            pw.write("用户名和密码正确");
            pw.flush();

            //调用shutDown方法关闭Socket输出流
            socket.shutdownOutput();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //关闭资源
            try {
                if (null != pw)
                    pw.close();
                if (null != out)
                    out.close();
                if (null != br)
                    br.close();
                if (null != isr)
                    isr.close();
                if (null != in)
                    in.close();
                if (null != socket)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
