package Homework;

import java.util.Arrays;

public class DayTwoEight {

    public static int[] decompressRLElist(int[] nums) {
        int[] res=new int[5000];
        int index=0;
        int i=0,j=1;
        while(i<nums.length&&j<nums.length){
            int count=0;
            while(count<nums[i]) {
                res[index++] = nums[j];
                count++;
            }
            i+=2;
            j+=2;
        }
       return Arrays.copyOfRange(res,0,index);
    }

    public int[] decompressRLElist1(int[] nums) {
        int[] ans = new int[5000];
        int toIndex = 0;
        for (int i = 0, fromIndex = 0; i < nums.length; i += 2) {
            toIndex = fromIndex + nums[i];
            while (fromIndex < toIndex) {
                ans[fromIndex++] = nums[i + 1];
            }
        }
        return Arrays.copyOf(ans, toIndex);
    }

    public static void main(String[] args) {
        /*String str = "hello world hello bit" ;
        //以空格划分，limit就是划分段数，以及数组长度
        String[] result = str.split(" ",2) ;
        for(String s: result) {
            System.out.println(s);
        }

        String[] result2 = str.split(" ") ;
        for(String s: result2) {
            System.out.println(s);
        }*/
        int[] nums={1,2,3,4};
        int[] res=decompressRLElist(nums);
        System.out.println(Arrays.toString(res));
    }
}

