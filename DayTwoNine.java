package Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayTwoNine {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    /*
                       List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[left++]);
                        list.add(nums[right--]);
                        result.add(list);

                     */
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }


    public static String fractionToDecimal1(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder fraction = new StringBuilder();
        // If either one is negative (not both)
        //利用异或符号不同，则为负
        //多了一点知识可以用异或符号
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }
        // Convert to Long or else abs(-2147483648) overflows
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(String.valueOf(dividend / divisor));
        long remainder = dividend % divisor;
        if (remainder == 0) {
            //没有余数
            return fraction.toString();
        }
        List<Long> list = new ArrayList<Long>();
        while (remainder != 0) {
            if (list.contains(remainder)) {
                
                fraction.append(")");
                break;
            }
            //加上余数
            list.add(remainder);
            remainder *= 10;
            fraction.append(String.valueOf(remainder / divisor));
            remainder %= divisor;
        }
        return fraction.toString();
    }

    public static void main(String[] args) {
        int a=1;
        int b=2;
        System.out.println(fractionToDecimal1(a,b));
    }
}
