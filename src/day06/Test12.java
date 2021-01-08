package day06;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 编写一个程序，将当前目录下所有的员工文件进行读取，并解析出所有员工为Emp
 * 对象并存入Map。其中key为该员工的名字，value为该员工的emp对象。
 * 然后，要求用户输入一个员工名字，若该员工存在，则输出该员工的名字，年龄，工资，以及入职20周年的纪念日当周的周六的日期。
 * 即:输入名字"张三"
 * 若该员工存在，则输出如下格式:
 * 张三,25,5000,2006-02-14
 * 入职20周年纪念日派对日期: 2026-02-14  （注:若入职日期为:2006-02-14）
 * 若该员工不存在，则输出:"查无此人"
 * @author Bonnie
 *
 */
public class Test12 {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedInputStream bufferedInputStream;
        byte[] bytes = new byte[80];
        HashMap<String,Emp> hashMap = new HashMap<>();
        String string;
        String[] strings;
        File file = new File(".");
        for (File file1 : file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".emp");
            }
        })){
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file1));
            int i =bufferedInputStream.read(bytes);
            string =new String(bytes);
            strings = string.split(",");
            hashMap.put(strings[0],new Emp(strings[0], Integer.valueOf(strings[1]), strings[2], Integer.valueOf(strings[3]), new SimpleDateFormat("yyyy-MM-dd").parse(strings[4])));
        }
        Scanner scanner = new Scanner(System.in);
        String empname=scanner.next();
        if (hashMap.containsKey(empname)){
            Emp emp = hashMap.get(empname);
            System.out.println(emp.toString());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(emp.getHiredate());
            calendar.add(Calendar.YEAR,20);
            System.out.println("入职20周年纪念日派对日期:"+new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
        }
        else {
            System.out.println("查无此人");
        }
    }
}
