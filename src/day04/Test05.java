package day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 创建一个List集合，并添加元素0-9
 * 将集合转换为一个Integer数组并输出数组每一个元素
 * @author Bonnie
 *
 */
public class Test05 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        List list = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        arrayList.addAll(list);
        Integer[] integers = arrayList.toArray(new Integer[0]);
        for (Integer integer:arrayList){
            System.out.println(integer);
        }
    }
}
