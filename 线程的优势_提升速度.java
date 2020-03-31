package Thread;

public class 线程的优势_提升速度 {
    private static final long COUNT=10_0000_0000L;
    private static final int N=10;

    private static void calc(){
        long r=0;
        for(long i=0;i<COUNT;i++){
            r+=i;
        }
        System.out.println(r);
    }

    private static class CalcThread extends Thread{
        @Override
        public void run(){
            //一个线程只需要计算一遍calc
            calc();
        }
    }

    //主线程一个线程在计算
    public static void main(String[] args) throws InterruptedException {
        long start=System.nanoTime();

        CalcThread[] threads=new CalcThread[N-1];
        //N个线程同时执行，起始主线程不需要创建，所以需要创建n-1个线程
        for(int i=0;i<N-1;i++){
            //创建了N-1个线程，每个线程都执行一次
            CalcThread thread=new CalcThread();
            //线程开始执行
            thread.start();
            threads[i]=thread;
        }
        //剩余一次，放到主线程中来计算
        calc();

        //什么时候记录结束时间？
        //代码走到这里的时候，只代表主线程中的calc计算完了，但
        //另外的N-1个线程是否计算完成，是不知道的
        //所以，我需要另外N-1线程全部完成，才能结束计时
        for(int i=0;i<N-1;i++){
            threads[i].join();
            //阻塞在这个方法上，直到threads[i]线程执行计数
        }
        //这代表所以的线程都执行结束了
        long end=System.nanoTime();
        double 耗时ms=(end-start)*1.0/1000/1000;
        System.out.println("耗时"+耗时ms);//900-1000
        /*
        //主线程一个线程在计算
        long start=System.nanoTime();
        for(int i=0;i<N;i++){
            calc();
        }
        long end=System.nanoTime();
        double 耗时ms=(end-start)*1.0/1000/1000;
        System.out.println("耗时:"+耗时ms);//3700-3800*/
    }


}
