package day09;

/**
 * 使用线程方式二创建两个线程:分别输出1000次，你好和再见
 *
 * @author Bonnie
 */
public class Test02 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("你好");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("再见");
                }
            }
        }).start();
    }
}
