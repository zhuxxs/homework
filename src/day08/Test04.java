package day08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

/**
 * 使用异常捕获机制完成下述读取操作
 * 读取emp.txt文件，并将每个员工信息读取出来，以一个Emp实例保存，然后将
 * 这些Emp实例存入到一个Map集合中。其中key为字符串，是该员工名字，而value
 * 是该Emp实例。
 * 存入后，要求用户输入一个员工的名字,如:张三
 * 若该员工存在则输出该员工所有信息(Emp的toString方法返回的字符串)
 * 输入的员工名若是英文，不要求区分大小写。
 * 若输入的员工名字不存在，则显示"查无此人"
 * 
 * @author Bonnie
 *
 */
public class Test04 {
    public static void main(String[] args) {
        HashMap<String,Emp>hashMap =new HashMap<>(10);
        try (BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(new FileInputStream("src/day08/emp.txt")))){
            String string;
            while ((string = bufferedReader.readLine())!=null){
                String[] strings =string.split(",");
                hashMap.put(strings[0],new Emp(strings[0],Integer.valueOf(strings[1]),strings[2],Integer.valueOf(strings[3]),new SimpleDateFormat("yyyy-MM-dd").parse(strings[4])));
            }
        }catch (IOException e){
            e.printStackTrace();
        }catch (ParseException e){
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        String string =scanner.next();
        if (string.matches("^[A-Za-z]+$")){
            string=string.substring(0,1).toUpperCase(Locale.ROOT)+string.substring(1,string.length()).toLowerCase();
        }
        if (hashMap.containsKey(string)){
            System.out.println(hashMap.get(string).toString());
        }
        else{
            System.out.println("查无此人");
        }
    }
}
