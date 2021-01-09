package day09;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 创建一个线程，每秒输出一次当前系统时间:yyyy-MM-dd HH:mm:ss
 * @author Bonnie
 *
 */
public class Test04 {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                Calendar calendar;
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                while (true){
                    calendar=Calendar.getInstance();
                    System.out.println(simpleDateFormat.format(calendar.getTime()));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
