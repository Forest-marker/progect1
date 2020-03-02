package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//373. 查找和最小的K对数字
//给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
//
//定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
//
//找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。

public class kSmallestPairs {
      /*public List<List<Integer>> KSmallestPairs(int[] nums1, int[] nums2, int k) {
        //利用暴力法求解
        List<List<Integer>> list=new LinkedList<>();
        int m=nums1.length;
        int n=nums2.length;
        if(n==0||m==0||k==0){
            return list;
        }
        int[][] res=new int[m*n][2];
        //存储每种可能的情况
        int index=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[index][0]=nums1[i];
                res[index][1]=nums2[j];
                index++;
            }
        }
        Arrays.sort(res,(o1,o2)->(o1[0]+o1[1])-(o2[0]+o2[1]));
        //看数组长度是否满足k（即是否<k),不满足就取数据的全部元素
        for(int i=0;i<Math.min(k,res.length);i++){
            List<Integer> tmp=new LinkedList<>();
            tmp.add(res[i][0]);
            tmp.add(res[i][1]);
            list.add(tmp);
            }
            return list;
    }*/

    public List<List<Integer>> KSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;
        //说明优先级队列中存放的是数组下标，利用下标对应的数组元素大小，然后进行排序

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (nums1[o1[0]]+nums2[o1[1]]) - (nums1[o2[0]]+nums2[o2[1]]));
        List<List<Integer>> result = new ArrayList<>();

        if (n1 == 0 || n2 == 0 || k == 0) return result;
        for (int i = 0; i < n1; i++) pq.offer(new int[]{i, 0});
        //此处先加入以一个数组所有元素开头的下标
        //先利用优先队列的顺序性选出一个最大的
        //再压入看是否有比之前小的，进行重新排序
        //隐含条件：数组都是升序，因此，几乎是前面不可能大的后面也不可能大（包含相等情况）
        while(pq.size() > 0 && k > 0) {
            int[] pair = pq.poll();
            if (pair[1] + 1 < n2) pq.offer(new int[]{pair[0], pair[1]+1});
            List<Integer> temp = new ArrayList<>();
            temp.add(nums1[pair[0]]);
            temp.add(nums2[pair[1]]);
            result.add(temp);
            k--;
        }

        return result;
    }
}
