package day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 创建一个List集合并添加元素0-9
 * 然后获取子集[3,4,5,6]
 * 然后将子集元素扩大10倍
 * 然后输出原集合。
 * 之后删除集合中的[7,8,9]
 * @author Bonnie
 *
 */
public class Test04 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        List list = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        arrayList.addAll(list);
        List<Integer> list1 = arrayList.subList(4,7);
        for (Integer integer : list1){
            integer*=10;
        }
        for (Integer integer : arrayList){
            System.out.print(integer+" ");
        }
        System.out.println();
        List list2 = Arrays.asList(7,8,9);
        arrayList.remove(list2);
        for (Integer integer : arrayList){
            System.out.print(integer+" ");
        }
        System.out.println();
    }
}
