package gittub;

//题目：1013. 将数组分成和相等的三个部分
//给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
//形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。

public class CanThreePartsEqualSum {
     /* public boolean canThreePartsEqualSum(int[] A) {
        int sum=0;
        for(int i=0;i<A.length;i++){
            sum+=A[i];
        }
        //0%3=0
        if(sum%3!=0){
            return false;
        }else{
            int tempsum=sum/3;
            int a=0;
            int count=0;
            for(int i=0;i<A.length;i++){
                a+=A[i];
                if(a==tempsum){
                    count++;
                    a=0;
                }
            }
            //最坏判断是否找到了3段（注意如果目标值是0的话可以大于3段）
            //特殊用例：-10 10 -10 10 -10 10 -10 10
            return count==3||(count>3&&sum==0);
        }
    }*/

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int num: A) {
            sum += num;
        }
        // 数组A的和如果不能被3整除返回false
        if (sum % 3 != 0) {
            return false;
        }
        // 遍历数组累加，每累加到目标值cnt加1，表示又找到1段,
        // 找到2段后就返回true（i只能到数组A的倒数第二个元素，保证了有第3段）
        sum /= 3;
        int curSum = 0, cnt = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curSum += A[i];
            if (curSum == sum) {
                cnt++;
                if (cnt == 2) {
                    return true;
                }
                curSum = 0;
            }
        }
        return false;
    }
}
