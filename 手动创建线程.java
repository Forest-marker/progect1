package Thread;

public class 手动创建线程 {
    //Thread自身已经实现Runnable方法
    //因此直接可以创建进程对象
    //继承Thread类，覆写run方法
   static class MyThread extends Thread{
       @Override
       public void run(){

       }
   }

   /* public static void main(String[] args) {
        MyThread t1=new MyThread();
        MyThread t2=new MyThread();

        //t1,t2这两个引用指向了各自的线程对象
        //线程最终要执行的是run方法中的代码
    }*/

   //首先实现MyRunnable接口，覆写run方法
    //其次创建Thread对象，把Runable对象传入
   /*static class MyRunnable implements Runnable{
       @Override
       public void run(){

       }
   }*/

    public static void main(String[] args) {
      //  MyRunnable mr1=new MyRunnable();
        //MyRunnable mr2=new MyRunnable();
        //Thread t4=new Thread(mr1);

        MyThread t11=new MyThread();
        MyThread t22=new MyThread();
        //最终线程需要有线程对象
        Thread t1=new Thread(t11);//mr1指向的任务作为t1的线程任务
        Thread t2=new Thread(t22);//mr2指向的任务作为t2线程的任务
        Thread t3=new Thread(t22);//mr2指向的任务作为t3线程的任务
    }
}
