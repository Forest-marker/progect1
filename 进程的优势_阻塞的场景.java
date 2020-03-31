package Thread;

import java.util.Scanner;

public class 进程的优势_阻塞的场景 {
    //时间复杂度O(2^n)
    private static long fib(int n){
        if(n<2){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }

    //若只有主线程，若一个n很大，则主线程一直停留在计算fib(n)，想进行下一个n的计算无法实现
    //重现启动一个进程，负责计算下一个fib(n)
    private static class FibThread extends Thread{
        private int n;
        FibThread(int n){
            this.n=n;
        }
        @Override
        public void run(){
            System.out.println(fib(n));
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(true){
            int n=scanner.nextInt();
            //在主线程中直接计算
            //System.out.println(fib(n));
            //重现启动一个线程，去计算fib(n)
            //主线程负责读取下一个数
            FibThread thread=new FibThread(n);
            thread.start();
        }
    }
}
