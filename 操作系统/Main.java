package 操作系统;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入进程的个数");
        int count=scanner.nextInt();
        Process[] p=new Process[count];
        System.out.println("请输入整个进程调度的时间片：");
        int timeSlice=scanner.nextInt();
        System.out.println("请输入每个进程的到达时间，服务时间，优先级，进程名：");
        for(int i=0;i<count;i++) {
            //String name=scanner.nextLine();
            int arriveTime = scanner.nextInt();
            int serveTime=scanner.nextInt();
            int prioritySenior=scanner.nextInt();
            String name=scanner.nextLine();
            p[i]=new Process(arriveTime,serveTime,prioritySenior,timeSlice,name);
        }
        while(true){
            System.out.println("==================");
            System.out.println("请输入您的选择:");
            System.out.println("1.FCF(先来先服务)");
            System.out.println("2.SJF(短作业优先）");
            System.out.println("3.PSA(优先级)");
            System.out.println("4.RR(时间片轮转)");
            System.out.println("==================");
            int select=scanner.nextInt();
            switch(select){
                case 1:
                    FCFS.FcFs(p);
                    Deal.Out(p);
                    break;
                case 2:
                    Process[] pro=SJF.sJF(p);
                    Deal.Out(pro);
                    break;
                case 3:
                    Process[] pr=PSA.pSA(p);
                    Deal.Out(pr);
                    break;
                case 4:
                    RR.rR(p);
                    Deal.Out(p);
                    break;

                default:
                    break;
            }
        }

    }

}
