package Offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
//滑动窗口的最大值
public class maxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        //8个元素 0-7 最大下标5 k=3
        if(nums.length==0){
            return nums;
        }
        int[] res=new int[nums.length-k+1];
        for(int i=0;i<=nums.length-k;i++){
            int max=0;
            for(int j=0;j<k-1;j++){
                if(nums[i+j]>max){
                    max=nums[i+j];
                }
            }
            res[i]=max;
        }
        return res;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        //利用双端队列，将元素压入队列，然后与后面进入的元素进行比较（每次都是最右端与即将要进入的元素进行比较），若最右端元素小即弹出，继续压比较，但是由于每次滑动窗口的大小为k,所有由于压入的时数组元素的下标，当最左端元素下标不符合要求即（<=i-k)，则弹出，当压入元素下标i+1=k开始即说明已经找到第一个滑动区间最大的值，之后每次队列的最左端即时一个滑动区间最大的元素。
        if(nums.length==0){
            return nums;
        }
        Deque<Integer> queue=new ArrayDeque<>();
        int[] res=new int[nums.length-k+1];
        int index=0;
        for(int i=0;i<nums.length;i++){
            //队列中有不是一个滑动区间的值，则弹出最开头元素
            if(!queue.isEmpty()&&queue.peekFirst()<=i-k){
                queue.pollFirst();
            }
            while(!queue.isEmpty()&&nums[queue.peekLast()]<=nums[i]){
                //与每次压入的元素做比较，若笑了就删除
                queue.pollLast();
            }
            //压入元素
            queue.offerLast(i);
            if(i+1>=k){
                //当i+1=k说明已经一个区间已经比较完毕
                res[index++]=nums[queue.peekFirst()];
            }
        }
        return res;
    }







    public static void main(String[] args) {
        int[] nums={1,3,-1,-3,5,3,6,7};
        int[] a=maxSlidingWindow(nums,3);
        LinkedList<Integer> list=new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        //System.out.println(list.pollFirst());//peek,poll都是删的第一个元素 1
        System.out.println(list.pollLast());
        Deque<Integer> queue=new ArrayDeque<>();
        queue.offerLast(1);
        queue.offerLast(2);
        queue.offerLast(3);
        System.out.println(queue);
        System.out.println(queue.peekLast());
    }
}
