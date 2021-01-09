package day07;

import java.io.*;
import java.util.Scanner;

/**
 * 记事本功能，首先要求用户输入一个文件名，并将该文件创建出来，
 * 然后通过控制台输入的每一行字符串都按行写入到该文件中，并
 * 使用GBK编码保存。当输入的字符串为"exit"时退出程序。
 * @author Bonnie
 *
 */
public class Test06 {
        public static void main(String[] args) throws IOException {
            String string;
            Scanner scanner = new Scanner(System.in);
            string = scanner.next();
            File file = new File(string);
            file.createNewFile();
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file),"GBK"));
            while (!(string= scanner.nextLine()).equals("exit")){
                printWriter.println(string);
            }
            printWriter.close();
        }
}
