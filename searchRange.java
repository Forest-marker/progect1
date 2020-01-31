package gittub;

 //题目：在排序数组中查找元素的第一个和最后一个位置
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//你的算法时间复杂度必须是 O(log n) 级别。
//如果数组中不存在目标值，返回 [-1, -1]。

public class searchRange {
    //法一：暴力搜索
    /*public int[] searchRange(int[] nums, int target) {
        int[] a=new int[]{-1,-1};
        int temp=1;
        for(int i=0;i<nums.length;i++){
            //第一次出现target
           if(temp==1&&nums[i]==target){
               a[0]=i;
               temp=0;
           }
           //第二次出现target
           //第一种可能，要么是本身是target后一个不是target
           //第二种可能是最后一个是target
          if(nums[i]==target&&(i==nums.length-1||nums[i+1]!=target)){
              a[1]=i;
          }

       }
       return a;

    }*/
    //法二：二分查找
    public int[] searchRange(int[] nums, int target) {
        int[] a=new int[]{-1,-1};
        a[0]=left_bound(nums,target);
        a[1]=right_bound(nums,target);
        return a;
    }

    private int left_bound(int[] nums,int target){
        int left=0;
        int right=nums.length;
        while(left<right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                right=mid;
                //缩小边界
            }else if(nums[mid]>target){
                right=mid;//开区间，不能为mid-1否则取不到
            }else{
                left=mid+1;
            }
        }
        if(left==nums.length){
            return -1;
        }
        return nums[left]==target?left:-1;
    }

    private int right_bound(int[] nums,int target){
        int left=0;
        int right=nums.length;
        while(left<right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                left=mid+1;
                //缩小边界
            }else if(nums[mid]>target){
                right=mid;//左闭右开
            }else{
                left=mid+1;
            }
        }
        if(left==0){
            return -1;
        }
        return nums[left-1]==target?(left-1):-1;
    }
}
