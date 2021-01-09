package day08;

import java.io.*;

/**
 * 对myfile.txt文件进行复制操作，要求使用异常捕获
 * 机制对流的异常进行捕获和处理，finally中
 * 要将流关闭
 * @author Bonnie
 *
 */
public class Test01 {
    public static void main(String[] args) {
        BufferedInputStream bufferedInputStream =null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream("mylife.txt"));
            bufferedOutputStream =new BufferedOutputStream(new FileOutputStream("mylife2.txt"));
            int i;
            byte[] bytes = new byte[1024];
            while ((i=bufferedInputStream.read(bytes))!=-1){
                bufferedOutputStream.write(bytes,0,i);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                bufferedInputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
