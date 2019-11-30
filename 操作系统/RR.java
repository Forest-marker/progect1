package 操作系统;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class RR {
    public static void rR(Process[] p){
        Deal.InsertSort(p);
        int time=p[0].arriveTime;
        int flag=1;//标记是否还有进程
        int sum=0;
        int n=p.length;
        int j;
        while(sum<n){
            //int k=0;
            flag=0;
            for(int i=0;i<n;i++){
               int k=0;
                if(p[i].single==1) continue;//标志进程已经被访问过
                else{
                    if(p[i].surplus<=p[i].timeSlice&&time>=p[i].arriveTime){
                        flag=1;//还有剩余其他进程未被访问
                        if(time>p[i].startTime){

                        }
                        else{
                            p[i].startTime=time;
                        }
                        time=time+p[i].surplus;
                        p[i].single=1;//标志此进程已经完成时间片
                        p[i].finfishTime=time;


                        p[i].wholeTime=p[i].finfishTime-p[i].arriveTime;
                        p[i].weightwholeTime=(double)p[i].wholeTime/(double)p[i].serveTime;
                        p[i].surplus=0;
                    }
                    //一个时间片并不能运行完
                    else if(p[i].surplus>p[i].timeSlice&&time>=p[i].arriveTime){
                        flag=1;
                        if(time>p[i].startTime){

                        }
                        else{
                            p[i].startTime=time;
                        }

                        time=time+p[i].timeSlice;
                        p[i].surplus-=p[i].timeSlice;
                    }
                    if(p[i].single==1){
                        sum++;
                    }
                }

            }
            if(flag==0&&sum<n){
                for(int i=0;i<n;i++){
                    if(p[i].single==0){
                        time=p[i].arriveTime;
                        break;
                    }
                }
            }

        }
    }
}
