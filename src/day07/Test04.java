package day07;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * 读取当前项目根目录下所有后缀为.obj的文件，将这些Emp对象读取出来
 * 并存入到一个List集合中，然后按照员工工资从多到少的顺序依次输出员工信息
 *
 * @author Bonnie
 */
public class Test04 {
    public static void main(String[] args) throws ParseException, IOException {
        BufferedInputStream bufferedInputStream;
        byte[] bytes = new byte[80];
        ArrayList<Emp> arrayList = new ArrayList<>();
        String string;
        String[] strings;
        File file = new File(".");
        for (File file1 : file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith("obj");
            }
        })) {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file1));
            int i = bufferedInputStream.read(bytes);
            string = new String(bytes);
            strings = string.split(",");
            arrayList.add(new Emp(strings[0], Integer.valueOf(strings[1]), strings[2], Integer.valueOf(strings[3]), new SimpleDateFormat("yyyy-MM-dd").parse(strings[4])));
        }
        arrayList.sort(new Comparator<Emp>() {
            @Override
            public int compare(Emp o1, Emp o2) {
                return o1.getSalary() - o2.getSalary();
            }
        });
        for (Emp emp : arrayList) {
            System.out.println(emp);
        }
    }
}
