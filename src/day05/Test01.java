package day05;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 创建一个队列，存入Integer类型元素1,2,3,4,5
 * 然后遍历队列并输出每个元素
 * @author Bonnie
 *
 */
public class Test01 {
    public static void main(String[] args) {
        PriorityQueue <Integer> priorityQueue = new PriorityQueue<>();
        List list = Arrays.asList(1,2,3,4,5);
        priorityQueue.addAll(list);
        for (Integer integer : priorityQueue){
            System.out.println(integer);
        }
    }
}
