package day02;
/**
 * 将字符串"123abc456def789ghi"中的英文部分替换为"#char#"
 * @author Bonnie
 *
 */
public class Test04 {
    public static void main(String[] args) {
        String string ="123abc456def789ghi";

        System.out.println(string.replaceAll("(abc)|(def)|(ghi)","#char#"));
    }

}
