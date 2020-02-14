package gittub;


//泰波那契序列 Tn 定义如下： 
//
//T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
//
//给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
public class Tribonacci {
     /*public int tribonacci(int n) {
        if(n==0){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
    }*/

    public int tribonacci(int n) {
        if(n==0){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        int x=0,y=1,z=1;
        int tmp=0;
        for(int i=3;i<=n;i++){
            tmp=x+y+z;
            x=y;
            y=z;
            z=tmp;
        }
        return tmp;
    }
}
