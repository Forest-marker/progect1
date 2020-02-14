package gittub;

import java.util.Arrays;

//跳水板
//你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
//
//返回的长度需要从小到大排列。

public class DivingBoard {
    public int[] divingBoard(int shorter, int longer, int k) {
        //k个木板 由shorter和longer组成
        if(k==0){
            return new int[0];
        }
        if(k==1){
            return new int[]{shorter,longer};
        }
        int res=k*shorter;
        if(shorter==longer){
            return new int[]{res};
        }
        int[] nums=new int[k+1];
        for(int i=0;i<=k;i++){
            //k=3 3 0
            //i=1 2 1
            //i=2 1 2
            //i=3 0 3
            int tmp=shorter*(k-i)+longer*(i);
            nums[i]=tmp;
        }
        //去重
        Arrays.sort(nums);
        //int index=0;
       /*for(int i=0;i<nums.length-1;i++){
           if(nums[i]!=nums[i+1]){
               nums[index++]=nums[i];
           }
       }*/
        //nums[index]=nums[nums.length-1];
        //注意区间为前闭后开，因此后者下标要多加1
        // return Arrays.copyOfRange(nums,0,index+1);
        return nums;
    }


    /*public int[] divingBoard(int shorter, int longer, int k) {
        //1+1+1 1+1+2 1+2+2 2+2+2 多了longer-shorter
        if(k==0){
            return new int[0];
        }
        if(k==1){
            return new int[]{shorter,longer};
        }
        int res=k*shorter;
        if(shorter==longer){
            return new int[]{res};
        }
        int[] nums=new int[k+1];
        int tmp=longer-shorter;
        nums[0]=res;
        for(int i=1;i<=k;i++){
            res+=tmp;
            nums[i]=res;
        }
        return nums;
    }*/
}
