package day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 创建一个List集合(ArrayList,LinkedList均可)
 * 存放元素"one","two","three","four"。
 * 获取集合第二个元素并输出。
 * 将集合第三个元素设置为"3"
 * 在集合第二个位置上插入元素"2"
 * 删除集合第三个元素。
 * @author Bonnie
 *
 */
public class Test03 {
    public static void main(String[] args) {
        ArrayList<String > arrayList = new ArrayList<>();
        List list = Arrays.asList("one","two","three","four");
        arrayList.addAll(list);
        System.out.println(arrayList.get(2));
        arrayList.set(2,"3");
        for (String str : arrayList){
            System.out.print(str+" ");
        }
        System.out.println();
        arrayList.add(1,"2");
        for (String str : arrayList) {
            System.out.print(str + " ");
        }
        System.out.println();
        arrayList.remove(2);
        for (String str : arrayList){
            System.out.print(str+" ");
        }
    }
}
