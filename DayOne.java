package DayOverDay_parctice;

import java.util.Scanner;

public class DayOne {
    static int um;
    static int a=0;
    public static void Run(){
        um+=2;
        a+=2;
        System.out.println(um+" "+a);
    }
    static class thread extends Thread{
        @Override
        public void run(){
            Thread a=currentThread();
            Run();
        }
    }

    //判断是否回文序列
    public static boolean isCircle(String A){
        StringBuilder tmp=new StringBuilder();
        tmp.append(A);
        return A.equals(tmp.reverse().toString());
    }

    //static int i;
    public static void main(String[] args) {
        /*System.out.println(i);//输出0
        //此处出错了，没有弄清楚round什么意思
        System.out.println(Math.round(10.5));//11
        System.out.println(Math.round(-11.5));//-11
        System.out.println(100%3);//1
        System.out.println(100%3.0);//1.0*/
        /*thread a=new thread();
        thread b=new thread();
        thread c=new thread();
        a.start();
        b.start();
        c.start();*/
        /*Scanner scanner=new Scanner(System.in);
        int count=0;
            String a=scanner.nextLine();
            String b=scanner.nextLine();
            for(int i=0;i<=a.length();i++){
                StringBuilder sb=new StringBuilder(a);
                sb.insert(i,b);
                if(isCircle(sb.toString())){
                    count++;
                }
            }
            System.out.println(count);*/
            String str="abcd";
        System.out.println(str.substring(0,2));
        System.out.println(str.substring(2));
    }
}
