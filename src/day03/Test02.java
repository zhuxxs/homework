package day03;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将当前系统时间以"yyyy-MM-dd HH:mm:ss"格式输出
 * @author Bonnie
 *
 */
public class Test02 {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat  simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date));
    }
}
