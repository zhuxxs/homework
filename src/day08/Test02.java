package day08;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 使用异常捕获完成下述操作
 * 将控制台输入的每一行字符串使用缓冲字符输出流PrintWriter
 * 按行以GBK编码写入到文件note.txt中
 *
 * @author Bonnie
 */
public class Test02 {
    public static void main(String[] args) {
        PrintWriter printWriter = null;
        Scanner scanner = new Scanner(System.in);
        String string;
        try {
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("note.txt"), "GBK"));
            while (!(string = scanner.next()).equals("exit")) {
                printWriter.println(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
                printWriter.close();
        }
    }
}
