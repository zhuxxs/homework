package day06;

import java.io.*;
import java.util.Scanner;

/**
 * 创建一个文件"note.txt",然后通过控制台输入的每一行字符串都按行写入到
 * note.txt中。当输入的字符串为"exit"时退出程序。
 * @author Bonnie
 *
 */
public class Test09 {
    public static void main(String[] args) throws IOException {
        String string;
        File file = new File("note.txt");
        file.createNewFile();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("note.txt"));
        Scanner scanner = new Scanner(System.in);
        while (!(string= scanner.nextLine()).equals("exit")){
            byte[] bytes = string.getBytes();
            bufferedOutputStream.write(bytes);
        }
        bufferedOutputStream.close();
    }
}
