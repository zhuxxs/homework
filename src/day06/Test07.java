package day06;

import java.io.*;
import java.util.Scanner;

/**
 * 要求用户输入一个文件名，并复制当前目录中该文件，并取名为"原文件名_copy.后缀名"
 * 定义两个方法分别使用单字节形式复制，以及字节数组形式复制
 * @author Bonnie
 *
 */
public class Test07 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		Test07 test07 =new Test07();
		test07.copy1(string);
		test07.copy2(string);
	}
	/**
	 * 使用单字节方式复制
	 * @param name 要复制的文件名
	 */
	public void copy1(String name) throws IOException {
		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(name));
		String newname = name.split("\\.")[0]+"_copy1."+name.split("\\.")[1] ;
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(newname));
		int i;
		while ((i=bufferedInputStream.read())!=-1){
			bufferedOutputStream.write(i);
		}
		bufferedInputStream.close();
		bufferedOutputStream.close();
	}
	/**
	 * 使用字节数组形式复制
	 * @param name 要复制的文件名
	 */
	public void copy2(String name) throws IOException{
		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(name));
		String newname = name.split("\\.")[0]+"_copy2."+name.split("\\.")[1] ;
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(newname));
		byte[] bytes=new byte[1024];
		int i;
		while ((i=bufferedInputStream.read(bytes,0,bytes.length))!=-1){
			bufferedOutputStream.write(bytes,0,i);
		}
		bufferedInputStream.close();
		bufferedOutputStream.close();
	}
}
