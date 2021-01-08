package day07;

import java.io.*;

/**
 * 使用缓冲流复制myfile.txt文件为myfile_cp2.txt
 * @author Bonnie
 *
 */
public class Test02 {
    public static void main(String[] args) throws IOException {
        BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream("mylife.txt"));
        BufferedOutputStream fileOutputStream =new BufferedOutputStream( new FileOutputStream("myfile_cp2.txt"));
        byte[] bytes =new byte[1024];
        int i;
        if ((i=fileInputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes,0,i);
        }
        fileInputStream.close();;
        fileOutputStream.close();
    }
}
