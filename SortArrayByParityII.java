package gittub;

//按奇偶排序数组 II
//给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
//对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
//你可以返回任何满足上述条件的数组作为答案。

public class SortArrayByParityII {
    /* public int[] sortArrayByParityII(int[] A) {
       //思路：开辟另外的空间，是偶数放在偶数下标，奇数放在奇数下标
       int N = A.length;
       int[] ans = new int[N];

       int t = 0;
       int r=1;
       for (int x: A) {
           if (x % 2 == 0) {
               //偶数
              ans[t] = x;
              t += 2;
          }else{
              //奇数
              ans[r] = x;
              r += 2;
            }
       }
        return ans;
   }*/
    //法二：不另外开辟空间，在原数组移动
    public int[] sortArrayByParityII(int[] A) {
        //思路：若是在相应位置则不动，不是在相应的位置则找到下一个不在相应位置，再交换
        //奇数下标，偶数下标
        int even=1;
        //偶数下标
        for(int odd=0;odd<A.length;odd+=2){
            //所在偶数下标不是偶数，继续判断下一个奇数下标是否奇数，若不是奇数，则和前面位置下标元素做交换,则继续判断下一个偶数下标所对应的元素
            if(A[odd]%2!=0){
                while(A[even]%2!=0){
                    even+=2;
                }
                int tmp=A[odd];
                A[odd]=A[even];
                A[even]=tmp;
            }
        }
        return A;
    }
}
