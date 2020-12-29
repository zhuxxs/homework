package day04;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 要求用户输入若干员工信息，格式为：
 * name,age,gender,salary,hiredate;name,age,gender,salary,hiredate;....
 * 例如:
 * 张三,25,男,5000,2006-02-15;李四,26,女,6000,2007-12-24;...
 * 然后将每个员工信息解析成Emp对象。并存入到一个集合中。
 * 然后循环集合，输出每一个员工信息(输出使用toString返回的字符串)
 * 然后输出每个员工的转正仪式日期。
 * 转正仪式日期为:入职3个月的当周周五
 * 
 * @author Bonnie
 *
 */
public class Test09 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Emp> empArrayList = new ArrayList<Emp>();
        String string = scanner.next();
        String[] strs = string.split(";");
        for (int i = 0; i < strs.length; i++) {
            String[] strings = strs[i].split(",");
            if (!empArrayList.contains(strings[0])) {
                empArrayList.add(new Emp(strings[0], Integer.valueOf(strings[1]), strings[2], Integer.valueOf(strings[3]), new SimpleDateFormat("yyyy-MM-dd").parse(strings[4])));
            }
        }
        for (Emp emp : empArrayList){
            System.out.println(emp.toString());
        }
        for (Emp emp : empArrayList){
            System.out.println(regular(emp.getHiredate()));
        }
    }

    public static String regular(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH,+3);
        calendar.set(Calendar.DAY_OF_WEEK,6);
        return simpleDateFormat.format(date);
    }
}
