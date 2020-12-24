package day01;

import java.util.Scanner;

/**
 * 随机生成一个5位的英文字母验证码(大小写混搭)
 * 然后将该验证码输出给用户，然后要求用户输入该验证码，大小写不限制。
 * 然后判定用户输入的验证码是否有效(无论用户输入大小写，只要字母都正确即可)。
 *
 * @author Bonnie
 */
public class Test05 {
    public static void main(String[] args) {
        boolean[] live = new boolean[52];
        String str = new String();
        char ch;
        int j = 0;
        for (int i = 0; i < 5; i++) {
            j = (int) (Math.random() * 52);
            while (live[j] == true) {
                j = (int) (Math.random() * 52);
            }
            live[j] = true;
            if (j > 25) {
                ch = (char) (j + 'A'-26);
            } else {
                ch = (char) (j + 'a');
            }
            str = str + ch;
        }
		System.out.println(str);
		System.out.println("请输入验证码");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		string=string.toLowerCase();
		if (string.equals(str.toLowerCase())){
			System.out.println("验证成功");
		}
		else{
			System.out.println("验证失败");
		}
    }

}
