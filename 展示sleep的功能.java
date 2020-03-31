package Thread;

import java.util.concurrent.TimeUnit;

public class 展示sleep的功能 {
    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();
        //long start=System.nanoTime();
        System.out.println(start);
        //Thread.sleep(5000);
        TimeUnit.SECONDS.sleep(5);
        long end=System.currentTimeMillis();
        //long end=System.nanoTime();
        System.out.println(end);
        System.out.println(end-start);
    }
}
