package day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 创建一个集合，存放元素"1","$","2","$","3","$","4"
 *   使用迭代器遍历集合，并在过程中删除所有的"$"，
 *   最后再将删除元素后的集合使用新循环遍历，并输出每一个元素。
 * @author Bonnie
 *
 */
public class Test02 {
    public static void main(String[] args) {
        ArrayList <String > arrayList = new ArrayList<>();
        List list = Arrays.asList("1","$","2","$","3","$","4");
        arrayList.addAll(list);
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            if (str.equals("$")){
                iterator.remove();
            }
        }
        for (String str : arrayList){
            System.out.println(str);
        }
    }
}
