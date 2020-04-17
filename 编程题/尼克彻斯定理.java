package DayOverDay_parctice.编程题;

import java.util.Scanner;

public class 尼克彻斯定理 {
    //思路：原本想从中间拆分，最后发现不是很成立
    //最后发现这是一系列的数字构成等差数列
    //可以找到最开始的数，利用每两个数之间相差2来依次计算后面的数字
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int start=n*n-(n-1);
        for(int i=0;i<n;i++){
            if(n==1){
                System.out.print(start);
                break;
            }
            if(i==n-1){
                System.out.print(start+2*i);
            }else{
                System.out.print(start+2*i+"+");
            }


        }
    }
}
