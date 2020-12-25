package day03;

import java.util.ArrayList;

/**
 * 创建一个集合，存放字符串"one","two"，"three"
 * 然后输出该集合的元素个数。
 * 然后输出该集合是否包含字符串"four"
 * 然后输出集合是否不含有任何元素
 * 然后清空集合
 * 然后输出该集合的元素个数
 * 然后输出集合是否不含有任何元素
 * @author Bonnie
 *
 */
public class Test06 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("one");
        arrayList.add("two");
        arrayList.add("three");
        System.out.println(arrayList.size());
        System.out.println(arrayList.contains("four"));
        System.out.println(arrayList.isEmpty());
        arrayList.clear();
        System.out.println(arrayList.size());
        System.out.println(arrayList.isEmpty());
    }
}
