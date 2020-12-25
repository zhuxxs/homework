package day02;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 要求用户输入若干员工信息，格式为：
 * name,age,gender,salary;name,age,gender,salary;....
 * 例如:
 * 张三,25,男,5000;李四,26,女,6000;...
 * 然后将每个员工信息解析成Person对象。并存入到一个数组中。
 * 然后循环数组，输出每一个员工信息(输出使用toString返回的字符串)
 * @author Bonnie
 *
 */
public class Test08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        String[] strings = string.split(";");
        String[] strs;
        Person[] people= new Person[]{};
        int count=0;
        for (String str:strings){
            people= Arrays.copyOf(people,people.length+1);
            strs=str.split(",");
            people[count]=new Person(strs[0],Integer.valueOf(strs[1]),strs[2],Integer.valueOf(strs[3]));
            count++;
        }
        for (Person person:people){
            System.out.println(person.toString());
        }
    }
}
