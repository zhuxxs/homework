package day06;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 通过File输出当前项目目录下的文件"myfile.txt"的名字，大小，最后修改时间。
 * 最后修改时间格式如:2017-06-30 14:22:16
 * @author Bonnie
 *
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        File file = new File("mylife.txt");
        String string = file.getName();
        System.out.println(string);
        Long num = file.length();
        System.out.println(num);
        Long lastModified = file.lastModified();
        Date date = new Date(lastModified);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(simpleDateFormat.format(date));

    }
}
