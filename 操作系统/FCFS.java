package 操作系统;

public class FCFS {
    //按照先后到达顺序排序

    public static void FcFs(Process[] p){
        Deal.InsertSort(p);
        for(int i=0;i<p.length;i++){
            //第一个进程特殊考虑
            if(i==0){
                p[i].finfishTime=p[i].arriveTime+p[i].serveTime;

            }else{
                //两种情况，到达时间大于上一个进程的完成时间
                if(p[i].arriveTime>p[i-1].finfishTime){
                    p[i].finfishTime=p[i].arriveTime+p[i].serveTime;
                    p[i].startTime=p[i].arriveTime;
                }
                else{
                    //到达时间小于或等于上一个进程的完成时间
                    p[i].finfishTime=p[i].serveTime+p[i-1].finfishTime;
                    p[i].startTime=p[i-1].finfishTime;
                }

            }
            //计算周转时间和带权周转时间
            p[i].wholeTime=p[i].finfishTime-p[i].arriveTime;
            p[i].weightwholeTime=(double)p[i].wholeTime/(double)p[i].serveTime;

        }
    }
}
