package Heap;

import java.util.Arrays;
//可以利用堆实现优先队列
//另一个应用：再海量数据中寻找前k大/小的数
//大数用小堆来实现，小鼠永达堆来实现节省空间
public class MyPriorityQueue {
    private int[] arr=new int[10];
    private int sz;
    public void offer(int value){
        if(sz==arr.length){
            arr=Arrays.copyOf(arr,arr.length*2);
        }
        //1.尾插
        //2.向上调整
        arr[sz++]=value;
        MyHeap.shifUpSmall(arr,sz,sz-1);
        //加入最后一个元素进行向上调整

    }
    public int poll(){
        if(sz>0){
            int tmp=arr[0];
            arr[0]=arr[sz-1];
            --sz;
            MyHeap.shifDownSmall(arr,sz,0);
            return tmp;
        }else{
            return -1;
        }
    }
    public int peek(){
        return arr[0];
    }
    public boolean isEmpty(){
        return sz==0;
    }
}
