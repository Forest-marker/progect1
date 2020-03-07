package Queue;


import java.util.ArrayDeque;
import java.util.Deque;

//题目：队列的最大值
//请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)
//若队列为空，pop_front 和 max_value 需要返回 -1
 class MaxQueue {

     /*int[] a=new int[10000];
    int begin=0,end=0;

    public MaxQueue() {

    }

    public int max_value() {
        int tmp=-1;
        for(int i=begin;i<end;i++){
            tmp=Math.max(tmp,a[i]);
        }
        return tmp;
    }

    public void push_back(int value) {
        a[end++]=value;
    }

    public int pop_front() {
        if(end==begin){
            return -1;
        }
        return a[begin++];
    }*/


    private Deque<Integer> queue;
    private Deque<Integer> help;

    public MaxQueue() {
        queue=new ArrayDeque<>();
        help=new ArrayDeque<>();
    }

    public int max_value() {
        return queue.isEmpty()?-1:help.peek();
    }

    public void push_back(int value) {
        //呈递减趋势，取最大值直接取出第一个即可
        queue.offer(value);
        while(!help.isEmpty()&&value>help.peekLast()){
            help.pollLast();
        }
        help.offer(value);
    }
    //1 2（2）
    //2 3 1（3 1）
    //3 1 2（3 2）
    public int pop_front() {
        if(queue.isEmpty()){
            return -1;
        }
        int val=queue.pop();
        if(help.peek()==val){
            help.pop();
        }
        return val;
    }
}
