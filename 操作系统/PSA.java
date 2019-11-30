package 操作系统;
import java.util.List;
import java.util.LinkedList;
//优先级算法
public class PSA {
    public static Process[] pSA(Process[] p){
        int now=0;
        //待处理list
        List<Process> list=new LinkedList<>();
        //结果res
        List<Process> res=new LinkedList<>();
        //按到达时间排序
        Deal.InsertSort(p);
        p[0].finfishTime=p[0].arriveTime+p[0].serveTime;
        p[0].wholeTime=p[0].finfishTime-p[0].arriveTime;
        p[0].weightwholeTime=p[0].wholeTime/p[0].serveTime;
        res.add(p[0]);
        now=p[0].arriveTime;
        //将剩余的进程全部添加到待处理list
        for(int i=1;i<p.length;i++){
            list.add(p[i]);
        }
        while(list.size()!=0){
            //寻找下一个进程
            //1.服务时间小于当前服务时间，到达时间小于当前完成时间
            Process next=Deal.FindNext(list,now);
            //分情况讨论，即没有满足1，返回第一个进程，若下一个进程的到达时间大于当前进程的完成时间
            //下一个进程的完成时间等于此进程的到达时间+服务时间
            //开始时间等于到达时间
            //now 代表进程完成时间
            if(next.arriveTime>now){
                next.finfishTime=next.arriveTime+next.serveTime;
                next.startTime=next.arriveTime;
            }else{
                //否则也就是找到下一个结点的情况，完成时间等于当前结点完成时间加上自身服务的时间
                //开始时间等于now
                next.finfishTime=now+next.serveTime;
                next.startTime=now;
            }
            now=next.finfishTime;
            next.wholeTime=next.finfishTime-next.arriveTime;
            next.weightwholeTime=(double)next.wholeTime/(double)next.serveTime;
            res.add(next);
        }
        return res.toArray(new Process[0]);
    }
}
