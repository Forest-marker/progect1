package Thread.使用java提供的方式通知停止;

import java.util.concurrent.TimeUnit;

public class B extends Thread{
    @Override
    public void run(){
        //B线程中判断是否有人让自己挖煤
        //此时进程若是休眠，则可以跳入catch异常中，可以说明灯亮了
        //与此同时因为是循环，可用break跳出
        while(Thread.interrupted()==false){
            System.out.println("挖煤");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
                break;
            }
        }
    }
}
