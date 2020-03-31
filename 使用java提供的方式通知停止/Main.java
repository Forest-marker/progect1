package Thread.使用java提供的方式通知停止;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        B b=new B();
        b.start();

        Scanner scanner=new Scanner(System.in);
        scanner.nextLine();

        b.interrupt();
    }
}
