package IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Administrator on 2017/6/27 0027.
 */
public class BufferedReaderDemo {
        public static void main(String[] args)  throws IOException {

            //创建一个字符读取流流对象，和文件关联
            FileReader rw = new FileReader("buf.txt");

            //只要将需要被提高效率的流作为参数传递给缓冲区的构造函数即可
            BufferedReader brw = new BufferedReader(rw);


            for(;;) {
                String s = brw.readLine();
                if(s==null) break;
                System.out.println(s);
            }

            brw.close();//关闭输入流对象

        }
}

