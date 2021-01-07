package day06;

import java.io.*;

/**
 * 创建一个"raf.dat"的文件，并在其中写出一个int的最大值，long的最大值，
 * 然后将其分别读取出来并输出
 *
 * @author Bonnie
 */
public class Test08 {
    public static void main(String[] args) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("raf.dat"));
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("raf.dat"));
        dataOutputStream.writeInt(Integer.MAX_VALUE);
        dataOutputStream.writeLong(Long.MAX_VALUE);
        dataOutputStream.close();
        System.out.println(dataInputStream.readInt());
        System.out.println(dataInputStream.readLong());
        dataInputStream.close();
    }
}