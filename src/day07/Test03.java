package day07;

import day06.Emp;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * 要求用户控制台输入想输入的员工人数（至少5个），然后依序输入员工信息，每行为
 * 一条员工信息，格式如:张三,25,男,5000,2006-3-18
 * 然后将该对象写入到文件<name>.obj并保存到当前项目根目录中，例如:张三.obj。
 * @author Bonnie
 *
 */
public class Test03 {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        String  string;
        BufferedOutputStream bufferedOutputStream;
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            string = scanner.next();
            String[] strings =string.split(",");
            Emp emp=new Emp(strings[0], Integer.valueOf(strings[1]), strings[2], Integer.valueOf(strings[3]), new SimpleDateFormat("yyyy-MM-dd").parse(strings[4]));
            byte[] bytes = emp.toString().getBytes();
            String name = emp.getName()+".obj";
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(name));
            bufferedOutputStream.write(bytes);
            bufferedOutputStream.close();
        }

    }
}
