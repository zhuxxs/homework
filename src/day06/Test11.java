package day06;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * 编写一个程序，将当前目录下所有员工文件进行读取，并解析出所有员工为Emp
 * 对象并存入集合。然后排序该集合，按照员工的年龄排序，年龄大的靠前，年龄小
 * 的靠后。排序完毕后输出结果。
 * @author Bonnie
 *
 */
public class Test11 {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedInputStream bufferedInputStream;
        DataInputStream dataInputStream;
        byte[] bytes = new byte[80];
        ArrayList<Emp> arrayList = new ArrayList<>();
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
            arrayList.add(new Emp(strings[0], Integer.valueOf(strings[1]), strings[2], Integer.valueOf(strings[3]), new SimpleDateFormat("yyyy-MM-dd").parse(strings[4])));
        }
        arrayList.sort(new Comparator<Emp>() {
            @Override
            public int compare(Emp o1, Emp o2) {
                return o1.getAge()- o2.getAge();
            }
        });
        for (Emp emp : arrayList){
            System.out.println(emp);
        }
    }
}
