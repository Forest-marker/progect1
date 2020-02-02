package gittub;

import java.util.Arrays;
import java.util.Stack;
 //最短无序连续子数组
//给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
//你找到的子数组应是最短的，请输出它的长度。
public class FindUnsortedSubarray {
     /* public int findUnsortedSubarray(int[] nums) {
        int left=0,right=nums.length-1;
        //2 6 4 8 10 9 15
        //2 4 6 8 9 10 15
        //先升序排列
        /*int[] temp=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            temp[i]=nums[i];
        }*/
    //浅拷贝
        /*int[] temp=nums.clone();
        Arrays.sort(temp);
        while(left<nums.length&&nums[left]==temp[left]){
            left++;
            //特殊情况考虑全是升序
            if(left==nums.length){
                return 0;
            }
         }
        while(right>=0&&nums[right]==temp[right]){
            right--;
         }
         return right-left+1;
    }*/
    //简化暴力搜索,时间复杂度很高，速度慢
     /*public int findUnsortedSubarray(int[] nums) {
         //思路：找到不成立的最小坐标和不成立的最大坐标
         int right=0;
         int left=nums.length;
         for(int i=0;i<nums.length-1;i++){
             for(int j=i+1;j<nums.length;j++){
                 if(nums[j]<nums[i]){
                     //前后两个元素不是升序
                     //找不成立的最右边坐标
                     //找不成立的最左边坐标
                     right=Math.max(right,j);
                     left=Math.min(left,i);
                 }
             }
         }
         //一次都没有进循环内，right==0,全是升序
         return right==0?0:right-left+1;
    }*/


    //排序的改进算法
    public int findUnsortedSubarray(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }

    //利用栈

    public int FindUnsortedSubarrayTwo(int[] nums) {
        //利用栈，从开头开始按升序压入元素，直至元素比栈顶元素小，找到合适的位置压入，记录下标，再继续压，重复此过程，找到最小的下标对应元素
        //逆序按降序，同样找到最大不成立元素的下标
        //利用空间最大为O(n)
        Stack<Integer> stack=new Stack<>();
        int left=nums.length,right=0;
        for(int i=0;i<nums.length;i++){
            while(stack.isEmpty()&&nums[i]<nums[stack.peek()]){
                left=Math.min(left,stack.pop());
            }
            stack.push(i);
        }
        stack.clear();

        for(int i=nums.length-1;i>=0;i--){
            while(stack.isEmpty()&&nums[i]>nums[stack.peek()]){
                Math.min(right,stack.pop());
            }
            stack.push(i);
        }
        return right==0?0:right-left+1;
    }
}
