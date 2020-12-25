package day02;

import java.util.Scanner;

/**
 * 输入一个数学计算表达式，如:1+2
 * 然后输出计算后的结果:1+2=3
 * 这里计算表达式只计算一次即可，可以使用加减乘除任意一个,可以进行小数运算。
 * @author Bonnie
 *
 */
public class Test07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        int index = string.indexOf("+")*string.indexOf("-")*string.indexOf("/")*string.indexOf("*")*-1;
        if (index<0 || index>string.length()){
            System.out.println("输入有误");
        }
        char ch= string.charAt(index);
        double num;
        if (ch== '+'){
            num=Double.valueOf(string.substring(0,index))+Double.valueOf(string.substring(index+1));
            System.out.println(string+"="+num);
        }
        else if (ch== '*'){
            num=Double.valueOf(string.substring(0,index))*Double.valueOf(string.substring(index+1));
            System.out.println(string+"="+num);
        }
        else if (ch== '-'){
            num=Double.valueOf(string.substring(0,index))-Double.valueOf(string.substring(index+1));
            System.out.println(string+"="+num);
        }
        else if (ch== '/'){
            num=Double.valueOf(string.substring(0,index))/Double.valueOf(string.substring(index+1));
            System.out.println(string+"="+num);
        }
    }
}
