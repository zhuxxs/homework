package day06;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 要求用户输入一个目录名并使用File在当前目录下创建出来。
 * 若该目录已经存在，则提示用户该目录已经存在。并创建副本，原则与第二题一致。
 * @author Bonnie
 *
 */
public class Test03 {
        public static void main(String[] args) throws IOException {
            Scanner scanner = new Scanner(System.in);
            String string = scanner.next();
            File file = new File(string);
            if (!file.exists()){
                file.mkdir();
                System.out.println("创建文件"+string);
            }
            else{
                int i=0;
                String str=string;
                while (file.exists()){
                    i++;
                    str = string + "_副本." + i ;
                    file = new File(str);
                }
                file.mkdir();
                System.out.println("创建文件"+str);
            }
        }
}
