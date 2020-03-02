package Heap;

import java.util.Arrays;

public class lastStoneWeight {
    /*public int lastStoneWeight(int[] stones) {
        //优先级队列，本来是升序排列，现在处理使其降序排列
        PriorityQueue<Integer> pq=new PriorityQueue<>((o1,o2)->(o2-o1));
        int i;
        for(i=0;i<stones.length;i++){
            pq.offer(stones[i]);
        }
        while(pq.size()>1){
            int x=pq.poll();
            int y=pq.poll();
            //优先级队列本来是降序，直接大数减小数
            if(x!=y){
                pq.offer(x-y);
            }
        }
        if(pq.isEmpty()){
            return 0;
        }
        return pq.poll();
    }*/

    public static int lastStoneweight(int[] stones){
        //有待思考
        //每次将数组升序排列，选择最大的两个数，取差值，赋值给倒数第二个元素，最后一个元素为0，再进行排序，最后剩的要不是0，要不是目标值
        //[2,7,4,1,8,1]6-1=5(5次比较)
        //1 1 2 4 7 8（排序）0
        //1 1 2 4 1
        //1 1 1 2 4（排序）1
        //1 1 1 2
        //1 1 1 2(排序)2
        //1 1 1
        //1 1 1(排序)3
        //1 0
        //0 1(排序)4
        //1
        for(int i=0;i<stones.length-1;i++){
            Arrays.sort(stones);
            stones[stones.length-1]= stones[stones.length-1] - stones[stones.length-2];
            stones[stones.length-2] = 0;
        }
        return stones[stones.length-1];
    }
}
