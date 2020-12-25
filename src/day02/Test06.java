package day02;

import java.util.Scanner;

/**
 * 测试正则表达式，并尝试编写规则: 电话号码可能有3-4位区号，
 * 7-8位号码:0415-5561111
 *
 * @author Bonnie
 */
public class Test06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        int index = string.indexOf('-');
        if (index == -1){
            System.out.println("错误号码");
        }
        else{
            String first = string.substring(0,index);
            String end = string.substring(index+1);
            if (first.matches( "[0-9]{3,4}") && end.matches( "[0-9]{7,8}")){
                System.out.println("正确号码");
            }
            else{
                System.out.println("错误号码");
            }
        }
    }
}
