package day07;

import java.io.*;
import java.net.URISyntaxException;

/**
 * 使用字符流复制当前程序的源文件到当前项目根目录下。
 * @author Bonnie
 *
 */
public class Test05 {
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(Test05.class.getClassLoader().getResource("/").toURI()))));

    }
}
