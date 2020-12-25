package day02;

import java.util.Scanner;

/**
 * 要求用户输入一个字符串，然后若该字符串是一个整数，则转换为整数后输出乘以10后的结果
 * 若是小数，则转换为一个小数后输出乘以5后的结果，若不是数字则输出"不是数字"
 * 需要使用正则表达式进行判断。
 * @author Bonnie
 *
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        String str = "^(\\-|\\+)?\\d+(\\.\\d+)?$";
        if (!string.matches(str)){
            System.out.println("不是数字");
        }
        else {
            int ch=string.indexOf('.');
            if (ch==-1){
                int i = Integer.valueOf(string);
                System.out.println(i*10);
            }
            else{
                String string2=string.substring(0,ch+2);
                int i =Integer.valueOf(string.substring(0,ch));
                double j = Integer.valueOf(string.substring(ch+1,ch+2));
                double sum=i*5+j*5/10;
                System.out.println(sum);
            }
        }
    }
}
