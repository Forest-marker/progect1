package gittub;

import java.util.Arrays;
import java.util.HashSet;

//两个数组的交集
//给定两个数组，编写一个函数来计算它们的交集。
//输入: nums1 = [1,2,2,1], nums2 = [2,2]
//输出: [2]
public class Intersection {
    /*public int[] intersection(int[] nums1, int[] nums2) {
       HashSet<Integer> set1=new HashSet<>();
       for(int a:nums1){
           set1.add(a);
       }
       HashSet<Integer> set2=new HashSet<>();
       for(int b:nums2){
           set2.add(b);
       }
       set1.retainAll(set2);
       int[] res=new int[set1.size()];
       int j=0;
       for(int c:set1){
           res[j++]=c;
       }
       return res;
    }*/

    //法二：双指针
   /* public int[] intersection(int[] nums1, int[] nums2) {
        //思路，先排序再比较
        HashSet<Integer> set=new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        while(i<nums1.length&&j<nums2.length){
         if (nums1[i] == nums2[j]) {
            set.add(nums1[i]);
            i++;
            j++;
             } else if (nums1[i] < nums2[j]) {
            i++;
            } else if (nums1[i] > nums2[j]) {
            j++;
        }

        }
        int[] res=new int[set.size()];
        i=0;
        for(int tmp:set){
            res[i]=tmp;
            i++;
        }
        return res;
    }*/

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<>();
        //满足二分查找的升序
        Arrays.sort(nums2);
        for(int target:nums1){
            if(binarySearch(nums2,target)&&!set.contains(target)){
                set.add(target);
            }
        }
        int[] res=new int[set.size()];
        int i=0;
        for(int tmp:set){
            res[i++]=tmp;
        }
        return res;
    }

    public boolean binarySearch(int[] a,int target){
        int left=0,right=a.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(a[mid]==target){
                return true;
            }else if(a[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return false;
    }
}
