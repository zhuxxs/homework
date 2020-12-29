package day05;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 创建一个栈，存入Integer类型元素1,2,3,4,5
 * 然后遍历队列并输出每个元素
 * @author Bonnie
 *
 */
public class Test02 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        List list = Arrays.asList(1,2,3,4,5);
        stack.addAll(list);
        for (Integer integer : stack){
            System.out.println(integer);
        }
    }
}
