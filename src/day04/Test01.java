package day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 创建一个集合c1，存放元素"one","two","three"
 * 再创建一个集合c2，存放元素"four","five","six"
 * 然后将c2元素全部存入c1集合
 * 然后在创建集合c3,存放元素"one,five"
 * 然后输出集合c1是否包含集合c3的所有元素
 * 然后将c1集合中的"two"删除后再输出c1集合
 * @author Bonnie
 *
 */
public class Test01 {
    public static void main(String[] args) {
        ArrayList<String> c1 = new ArrayList<String>();
        ArrayList<String> c2 = new ArrayList<>();
        List list = Arrays.asList("one","two","three");
        c1.addAll(list);
        list = Arrays.asList("four","five","six");
        c2.addAll(list);
        c1.addAll(c2);
        ArrayList<String>c3 = new ArrayList<>();
        c3.add("one");
        c3.add("five");
        System.out.println(c1.contains(c3));
        c1.remove("two");
        for (String str : c1)
        {
            System.out.println(str);
        }
    }
}