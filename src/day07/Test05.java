package day07;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * 使用字符流复制当前程序的源文件到当前项目根目录下。
 * @author Bonnie
 *
 */
public class Test05 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(Test05.class.getClassLoader().getResource("day06/Test01.java").toURI()))));
        Path tarpath = Paths.get(".");
        Path path = Paths.get(Test05.class.getClassLoader().getResource("day06/Test01").toURI());
        Files.copy(path,tarpath, StandardCopyOption.REPLACE_EXISTING);
    }
}