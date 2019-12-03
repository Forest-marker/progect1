package 操作系统;
import java.util.ArrayList;
import java.util.List;
public class NewRR {
    public static void rR(Process[] p){
        List<List<Integer>> list=new ArrayList<>() ;
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
                list.add(new ArrayList<>());
                if(p[i].single==1) continue;//标志进程已经被访问过
                else{
                    if(p[i].surplus<=p[i].timeSlice&&time>=p[i].arriveTime){
                        flag=1;//还有剩余其他进程未被访问
                        list.get(i).add(time);
                        time=time+p[i].surplus;
                        p[i].single=1;//标志此进程已经完成时间片
                        p[i].finfishTime=time;
                        p[i].startTime=list.get(i).get(0);


                        p[i].wholeTime=p[i].finfishTime-p[i].arriveTime;
                        p[i].weightwholeTime=(double)p[i].wholeTime/(double)p[i].serveTime;
                        p[i].surplus=0;
                    }
                    //一个时间片并不能运行完
                    else if(p[i].surplus>p[i].timeSlice&&time>=p[i].arriveTime){
                        flag=1;
                        list.get(i).add(time);
                        time=time+p[i].timeSlice;
                        p[i].surplus-=p[i].timeSlice;
                        p[i].startTime=list.get(i).get(0);
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
