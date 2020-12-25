package day02;

import java.util.Arrays;

/**
 * 将字符串123,456,789,012根据","拆分，并输出拆分后的每一项
 * @author Bonnie
 *
 */
public class Test02 {
    public static void main(String[] args) {
        String string ="123,456,789,012";
        for (String str : string.split(",")){
            System.out.println(str);
        }
    }
}

