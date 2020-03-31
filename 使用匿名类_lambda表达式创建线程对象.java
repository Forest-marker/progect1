package Thread;

public class 使用匿名类_lambda表达式创建线程对象 {
    //匿名类
    public static void main1(String[] args) {
        Thread t=new Thread(){
            @Override
            public void run(){

            }
        };

        Thread t2=new Thread(new Runnable(){
            @Override
            public void run(){

            }
        });
    }

    public static void main2(String[] args) {
        Thread t=new Thread(){
            @Override
            public void run(){

            }
        };

        Thread t2=new Thread(new Runnable(){
            @Override
            public void run(){

            }
        });
    }
}
