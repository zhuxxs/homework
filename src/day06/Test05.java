package day06;

import java.io.File;
import java.util.Scanner;

/**
 * 要求用户输入一个文件或目录名，并删除当前目录下的该文件或目录。
 * 可自行手动先在当前项目目录中创建一个要删除的文件或目录，若是目录，还可以
 * 在该目录中继续创建若干级目录和文件。
 * @author Bonnie
 *
 */
public class Test05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        File file = new File(string);
        if (file.isFile()){
            file.delete();
        }
        else{
            del(file);
            file.delete();
        }
    }
    public  static void del(File file){
        File[] files = file.listFiles();
        if (files ==null ) return;
        else {
            for (File file1 : files){
                if (file1.isDirectory()){
                    del(file1);
                    file1.delete();
                }
                else {
                    file1.delete();
                }
            }
        }
    }
}
