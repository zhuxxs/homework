package day08;

import day06.Emp;
import day06.Test13;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;

/**
 * 使用异常捕获机制完成下述读取操作，并在finally中有关闭RandomAccessFile操作。
 * 将emp.dat文件中所有员工解析出来，并创建为若干Emp实例存入一个
 * 集合，然后按照员工入职从晚到早的顺序依次输出员工信息。
 * 
 * 该文件560字节，每56个字节为一个员工的信息。
 * 其中:
 * 	 name为字符串，长度为32个字节，编码为:UTF-8
 *   age为short,长度为2个字节
 * 	 gender为字符串，长度为10个字节，编码为:UTF-8
 * 	 salary为int,长度为4个字节
 * 	 hiredate为long，长度为8个字节
 * 格式可参考当前包中emp.jpg图
 * @author Bonnie
 *
 */
public class Test05 {
    public static void main(String[] args) {
        RandomAccessFile randomAccessFile = null;
        ArrayList<Emp> arrayList = new ArrayList<>();
        byte[] namebytes = new byte[32];
        byte[] genderbytes = new byte[10];
        int salary;
        short age;
        Long giredatebytes;
        try {
            File file = new File(Test13.class.getClassLoader().getResource("day08/emp.dat").toURI());
            randomAccessFile =new RandomAccessFile(file,"rw");
            for (int i = 0; i < 10; i++) {
                randomAccessFile.read(namebytes);
                age = randomAccessFile.readShort();
                randomAccessFile.read(genderbytes);
                salary=randomAccessFile.readInt();
                giredatebytes = randomAccessFile.readLong();
                arrayList.add(new day06.Emp(new String(namebytes),(int)age,new String(genderbytes),salary,new Date(giredatebytes)));
            }
            for (Emp emp:arrayList){
                System.out.println(emp.toString());
            }
        }catch (IOException e){
            e.printStackTrace();
        }catch (URISyntaxException e){
            e.printStackTrace();
        } finally{
            try {
                randomAccessFile.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
