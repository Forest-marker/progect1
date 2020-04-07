package DayOverDay_parctice.DayThree;

import java.util.Scanner;
public class Main{
/*public static int Counts(int n){
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
                    return count;
                }
                if(b<6){
                    break;
                }
            }
 
        }
        return -1;
 
    }*/
  //方法二：因为只能6个或8个一个袋子，可以判断满足条件的一定是偶数，奇数都不成立
  //n%8 只可能是0，2，4，6
  //0时，恰好需要n/8个袋子
  //2时，回溯两次，8+8+2=18/6=3 所需袋子数变成n/8-2+3=n/8+1
  //4时，回溯一次,8+4=12/6=2,所需袋子个数变成n/8-1+2+n/8+1
  //6时，刚好再用6个每袋的袋子，所需袋子数为n/8+1
  /*public static int count(int n){
    if(n%2!=0||n==10||n<6){
      return -1;
    }
    if(n%8==0){
      return n/8;
    }
    return n/8+1;
  }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println(count(n));
    }*/
   
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
System.out.println(buyA(n));
}
public static int buyA(int n){
int res=-1;
int p=20;
if(n%2==1||n<6) return -1;
for(int i=0;i<=n/8;i++){
for(int j=0;j<=n/6;j++){
if(i*8+j*6==n){
//res=i+j<p?i+j:p;
  res=i+j;
}
}
}
return res;
}
 
}