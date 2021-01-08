package day07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用文件流复制myfile.txt文件为myfile_cp.txt
 * @author Bonnie
 *
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("mylife.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("myfile_cp.txt");
        byte[] bytes =new  byte[1024];
        int i;
        if ((i=fileInputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes,0,i);
        }
        fileInputStream.close();;
        fileOutputStream.close();
    }
}
