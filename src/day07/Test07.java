package day07;

import java.io.*;
import java.util.Scanner;

/**
 * 要求用户输入一个文件，该文件应当是Test07程序生成的文件，然后将该文件中所有字符读取
 * 出来，并以UTF-8编码写入到另一个文件中，实现文件转码工作，该文件取名格式:原文件名_utf.txt。
 * @author Bonnie
 *
 */
public class Test07 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String string =scanner.next();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(string),"GBK"));
        String newname = string.split("\\.")[0]+"_uft."+string.split("\\.")[1];
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter( new FileOutputStream(newname)));
        while ((string=bufferedReader.readLine())!=null){
            printWriter.println(string);
        }
        printWriter.close();
        bufferedReader.close();
    }
}
