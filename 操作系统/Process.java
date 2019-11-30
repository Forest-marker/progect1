package 操作系统;

public class Process {
    public String name;
    public int arriveTime;
    public int serveTime;
    public int prioritySenior;
    public int timeSlice;
    public int finfishTime;
    public int startTime;
    public int wholeTime;
    public double weightwholeTime;
    public int single;//是否进程已完成
    public int surplus;//剩余服务时间
    public int index;
    Process(int x,int y,int r,int q,String z){
        arriveTime=x;
        serveTime=y;
        prioritySenior=r;
        timeSlice=q;
        surplus=y;
        name=z;
        single=0;
    }
}
