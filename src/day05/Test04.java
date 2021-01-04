package day05;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 创建一个Map，保存某个学生的成绩:
 * 在控制台输入该学生成绩，格式:
 * 科目:成绩;科目:成绩;...
 * 例如:
 * 语文:99;数学:98;英语:97;物理:96;化学:95
 * 然后输出物理的成绩。
 * 然后将化学的成绩设置为96
 * 然后删除英语这一项。
 * 然后遍历该Map分别按照遍历key，Entry，value
 * 的形式输出该Map信息。
 *
 * @author Bonnie
 */
public class Test04 {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        String[] strs = string.split(";");
        for (int i = 0; i < strs.length; i++) {
            String[] strings = strs[i].split(":");
            hashMap.put(strings[0], Integer.valueOf(strings[1]));
        }
        System.out.println(hashMap.get("物理"));
        hashMap.replace("化学",96);
        hashMap.remove("英语");
        for (String str: hashMap.keySet()){
            System.out.println(str);
        }
        for (Integer integer : hashMap.values()){
            System.out.println(integer);
        }
        for (Map.Entry<String,Integer> set : hashMap.entrySet()){
            System.out.println(set);
        }
    }
}
