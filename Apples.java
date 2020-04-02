package DayOverDay_parctice.DayThree;

import java.util.Scanner;

public class Apples{
    public static int Counts(int n){
        int tmp=n/8;
        for(int i=tmp;i>=0;i--){
            int sum=n;
            int count=0;
            int a=0;//商
            int b=n;//余数
            while(b>=6){
                a=i;
                count=count+a;
                b=sum-8*i;
                //System.out.println(a+" "+b);
                if(b==0){
                   System.out.println(1);
                    return count;
                }
                if(b<6){
                    break;
                }
                a=b/6;
                count=count+a;
                b=b%6;
                //System.out.println(a+" "+b);
                if(b==0){
                    System.out.println(2);
                    return count;
                }
                if(b<6){
                    break;
                }
            }

        }
        return 0;

    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println(Counts(n));
    }
}
