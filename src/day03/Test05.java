package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 实现时间的计算: 要求用户输入身份证号，若格式有误，要求其重新输入。然后根据身份证号码输出20岁生日
 * 所在周的周三的日期。
 * 例如:
 * 出生日期:1992-07-15。
 * 20岁生日:2012-07-15
 * 当周的周三为:2012-07-18
 * @author Bonnie
 *
 */
public class Test05 {
    public static void main(String[] args) throws ParseException {
        String regx = "(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)";
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        if (string.matches(regx) ){
            string = string.substring(string.length()-12,string.length()-4);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyymmdd");
            Date date =simpleDateFormat.parse(string);
            simpleDateFormat.applyPattern("yyyy-mm-dd");
            System.out.println("出生日期："+simpleDateFormat.format(date));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.YEAR,20);
            date=calendar.getTime();
            System.out.println("20岁的生日："+simpleDateFormat.format(date));
            calendar.add(Calendar.DAY_OF_WEEK,4);
            date=calendar.getTime();
            System.out.println("当周的周三："+simpleDateFormat.format(date));
        }
        else {
            System.out.println("输入错误，请重新输入");
        }
    }
}
