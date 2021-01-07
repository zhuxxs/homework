package day06;

import java.io.File;

/**
 * 获取并输出当前目录下所有文件的名字
 * @author Bonnie
 *
 */
public class Test06 {
    public static void main(String[] args) {
        for (File string : new File(".").listFiles()){
            System.out.println(string.getName());
        }
    }
}
