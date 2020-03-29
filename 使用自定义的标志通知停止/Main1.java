package Thread.使用自定义的标志通知停止;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Thread main=Thread.currentThread();
        System.out.println("主线程"+main.getId());
        B1 b=new B1();
        b.start();

        Scanner scanner=new Scanner(System.in);
        System.out.println("随便输出什么");
        scanner.nextLine();
        b.run=false;

    }
}
