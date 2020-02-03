package gittub;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//两个数组的交集 II
//给定两个数组，编写一个函数来计算它们的交集。
//
//示例 1:
//输入: nums1 = [1,2,2,1], nums2 = [2,2]
//输出: [2,2]
public class intersectProve {
    public int[] intersect(int[] nums1, int[] nums2) {
        //二分查找先抛弃 无法显示重复的元素是否存在
        //双指针
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len=nums1.length<nums2.length?nums1.length:nums2.length;
        //无法初始化数组的长度
        // int[] res=new int[len];
        List<Integer> list=new LinkedList<>();
        int i=0,j=0,index=0;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]==nums2[j]){
                nums1[index++]=nums1[i];
                // list.add(nums1[i]);
                i++;
                j++;

            }else if(nums1[i]>nums2[j]){
                j++;
            }else if(nums1[i]<nums2[j]){
                i++;
            }
        }
        /*int[] res=new int[list.size()];
         i=0;
        for(int s:list){
            res[i++]=s;
        }
        return res;
        //错误，尚未理解清楚//return list.toArray(new int[]{});*/
        return Arrays.copyOfRange(nums1, 0, index);

    }


   /* public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> a1=new LinkedList<>();
        List<Integer> a2=new LinkedList<>();
        for(int a:nums1){
            a1.add(a);

        }
        for(int b:nums2){
            a2.add(b);
        }
        a1.retainAll(a2);
        int i=0;
        int[] res=new int[a1.size()];
        for(int a:a1){
            res[i++]=a;
        }
    return res;
    }*/
}
