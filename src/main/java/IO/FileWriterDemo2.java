package IO;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Administrator on 2017/6/27 0027.
 */
public class FileWriterDemo2 {
       public static void main(String[] args) {

            try {
                //传递一个参数,代表不覆盖已有的数据。并在已有数据的末尾进行数据续写
                FileWriter fw = new FileWriter("F:\\1.txt",true);
                fw.write(" is charactor table?");
                fw.close();
            }
            catch (IOException e) {
                sop(e.toString());
            }

        }

        /**********************Println************************/
        private static void sop(Object obj)
        {
            System.out.println(obj);
        }
 }

