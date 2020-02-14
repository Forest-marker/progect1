package gittub;

//给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
//
//（注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）

public class CountPrimeSetBits {
    // L，R 最大为 10^6 转换为二进制，有 20 位，故 计算置位 个数不会超过 20。即求出 20 以内的质数列表即可。/使用             Integer.bitCount(i) 函数可快速求得 i 的二进制形式中 1 的个数。

  /* public int countPrimeSetBits(int L, int R) {
        //0-20的质数列表，prime[i]为1，则i为质数
        int[] primes = {0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1};
        int res = 0;
        for (int i = L; i <= R; i++) {
            int t = Integer.bitCount(i);
            res += primes[t];
        }
        return res;
    }*/

    public int countPrimeSetBits(int L, int R) {
        int count=0;
        int res=0;
        for(int i=L;i<=R;i++){
            int tmp=i;
            count=0;
            while(tmp!=0){
                if((tmp&1)==1){
                    count++;
                }
                tmp=tmp>>1;
            }
            if(ifPrime(count)){
                res++;
            }
        }
        return res;
    }

    public boolean ifPrime(int i){
        if(i<2){
            return false;
        }
        for(int j=2;j*j<=i;j++){
            if(i%j==0){
                return false;
            }
        }
        return true;
    }

}
