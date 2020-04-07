package DayOverDay_parctice.DaySeven;

import java.util.Scanner;

public class Main {
  /*
  用例:
502 94278

对应输出应该为:

23663778

你的输出为:

47327556
   */
  //以下方法考虑不全
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        if(a>b){
            if(a%b==0){
                System.out.println(a);
            }else{
                System.out.println(a*b);
            }
        }else if(a<b){
            if(b%a==0){
                System.out.println(b);
            }else{
                System.out.println(a*b);
            }
        }else{
            System.out.println(a);
        }
        LeastMultiple(a,b);
    }
    //求最大公约数
    public static void LeastMultiple(int m,int n){
        //根据唯一分解定理：一个数的最小公倍数*最大公约数=两数成绩
        int min=Math.min(m,n);
        int p=0;
        for (int i = 1; i <= min; i++){
            //求最大公约数的核心代码
            if (m%i == 0 && n%i == 0){
                p = i;
            }
        }
        int res=(m*n)/p;
        System.out.println(res);
    }
}
