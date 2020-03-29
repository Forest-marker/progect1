package Thread.使用自定义的标志通知停止;

import java.util.concurrent.TimeUnit;

public class B1 extends Thread{
    public static boolean run=true;

    @Override
    public void run(){
        Thread thread=currentThread();
        while(run){
            System.out.println(thread.getId()+"挖煤");
            try {
                //处于睡眠状态，无法接收到通知
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
