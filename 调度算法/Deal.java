package 操作系统;

import java.util.List;
public class Deal {
    public static void Out(Process[] p) {
        float sumWT = 0;
        float sumWWT = 0;
        float AverWT;
        float AverWWt;
        for (int i = 0; i < p.length; i++) {
           // System.out.println("时刻" + p[i].startTime + "进程" + p[i].name +
                    //"开始运行,完成时间为:" + p[i].finfishTime +
                   // "周转时间为：" + p[i].wholeTime + "带权周转时间为:" + p[i].weightwholeTime);
           System.out.println( "进程:" + p[i].name +"     "  + "开始时间:"+p[i].startTime +"     " +"完成时间:"
                    + p[i].finfishTime + "     "  +"周转时间：" + p[i].wholeTime+"     "
                    + "带权周转时间为:" + p[i].weightwholeTime);
            System.out.println( "进程:" +"     "  + "开始时间:"+"     " +"完成时间:"
                     + "     "  +"周转时间：" + "     "
                     + "带权周转时间为:" );
            System.out.println( p[i].name +p[i].startTime + p[i].finfishTime + p[i].wholeTime + p[i].weightwholeTime);

            sumWT+=p[i].wholeTime;
            sumWWT+=p[i].weightwholeTime;
        }
        AverWT = sumWT / p.length;
        AverWWt = sumWWT / p.length;
        System.out.println("平均周转时间为：" + AverWT);
        System.out.println("平均带权周转时间为：" + AverWWt);
    }

    //寻找下一个结点（短作业优先）
    public static Process FindNextPro(List<Process> list, int now) {
        Process pro = list.get(0);
        int index = 0;
        for (int i = 1; i < list.size(); i++) {
            //多道程序，进程可以都进入内存
            //服务时间小于当前服务时间，到达时间小于当前完成时间
            if (list.get(i).serveTime < pro.serveTime && list.get(i).arriveTime < now) {
                pro = list.get(i);
                index = i;
            }
        }
        //移除已找到的进程相关信息
        list.remove(index);
        return pro;
    }

    public static Process FindNext(List<Process> list, int now) {
        Process pro = list.get(0);
        int index = 0;
        for (int i = 1; i < list.size(); i++) {
            //多道程序，进程可以都进入内存
            //服务时间小于当前服务时间，到达时间小于当前完成时间
            if (list.get(i).prioritySenior >pro.prioritySenior&& list.get(i).arriveTime < now) {
                pro = list.get(i);
                index = i;
            }
        }
        //移除已找到的进程相关信息
        list.remove(index);
        return pro;
    }
    //插入排序按到达时间来排序，先来先服务
    public static void InsertSort(Process[] arr){
        int i,j;
        int n=arr.length;
        //创建一个进程对象
        Process target;
        for(i=1;i<n;i++){
            j=i;
            //对象初始化
            target=arr[i];
            //后一个进程到达时间小于前一个进程达到时间，把两个进程交换一i下位置
            //
            while(j>0&&target.arriveTime<arr[j-1].arriveTime){
                arr[j]=arr[j-1];
                j--;
            }
            arr[j]=target;
        }
    }
}