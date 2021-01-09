package day08;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * 使用异常捕获机制完成下述IO操作
 * 编写程序，要求下面的类实现功能:
 * 添加新员工
 * 要求用户输入一个员工信息，格式如下:
 * jackson,25,男,5000,2008-12-22
 * 用户输入后需要做下述验证:
 * 要求用户名长度在1-20个字符之间且必须是英文
 * 年龄在0-100之间的整数
 * 性别只能是:"男"或"女"
 * 当发现用户输入有不符合规定时，提醒用户
 * 相关内容输入不符合要求，并要求重新输入。
 * 都输入正确后，将该员工添加到emp.txt文件
 * 的最后一行。
 * 
 * @author Bonnie
 *
 */
public class Test06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Boolean flag = true;
        String string;
        String[] strings;
        Emp emp=null;
        while (flag){
            string =scanner.next();
            try {
                strings=string.split(",");
                if (strings[0].matches("^[A-Za-z]{1,20}+$") && Integer.valueOf(strings[1])>=0 && Integer.valueOf(strings[1])<=100 && (strings[2].equals("男") || strings[2].equals("女"))){
                    flag=false;
                    emp = new Emp(strings[0],Integer.valueOf(strings[1]),strings[2],Integer.valueOf(strings[3]),new SimpleDateFormat("yyyy-MM-dd").parse(strings[4]));
                }
            }catch (Exception e){
                System.out.println("输入错误");
            }
        }
        try (PrintWriter printWriter =new PrintWriter(new OutputStreamWriter(new FileOutputStream("emp.txt",true))) ){
            printWriter.println(emp.toString());
            System.out.println("添加成功");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
