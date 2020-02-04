package Sorted;

import java.util.Arrays;

public class BubbleSort {
    //冒泡排旭
    public static void  bubble(int[] nums){
        int temp=0;
        for(int i=0;i<nums.length-1;i++){
            boolean isSorted=true;
            for(int j=0;j<nums.length-i-1;j++){
               if(nums[j]>nums[j+1]){
                   temp=nums[j];
                   nums[j]=nums[j+1];
                   nums[j+1]=temp;
               }
            }
            //若是有序的就不会进入for循环内部if判断语句，则内部循环完毕后，就直接跳出，不进行下一下比较
            if(isSorted){
                break;
            }
        }
    }


        public static void main(String[] args) {
        int[] nums={2,1,3,5,4,6};
        bubble(nums);
        System.out.println(Arrays.toString(nums));
    }
}
