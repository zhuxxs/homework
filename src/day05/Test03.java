package day05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 要求用户输入若干员工信息，格式为：
 * name,age,gender,salary,hiredate;name,age,gender,salary,hiredate;....
 * 例如:
 * 张三,25,男,5000,2006-02-15;李四,26,女,6000,2007-12-24;...
 * 然后将每个员工信息解析成Emp对象。并存入到一个List集合中。
 * 并对集合排序，然后输出每个员工信息。
 * <p>
 * 再根据员工的入职时间排序，入职晚的在前，早的在后并
 * 输出每个员工的信息。
 *
 * @author Bonnie
 */
public class Test03 {
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
        for (Emp emp : empArrayList) {
            System.out.println(emp.toString());
        }
        Collections.sort(empArrayList);
        for (Emp emp : empArrayList) {
            System.out.println(emp.toString());
        }
    }

}
