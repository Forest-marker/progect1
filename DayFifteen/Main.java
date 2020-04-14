package DayOverDay_parctice.DayFifteen;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int min=Math.min(1000000007-n,n);
        System.out.println(1000000007-n);
        /*int index=0;
        for(int i=1;i<min-7/(8*n);i++){
            for(int j=1;j<min-3/(4*n);j++){
                if(i*(4*n)+3+j*(8*n)+7>=min){
                    if(index==0){
                        index=i+j;
                    }else{
                        if(i+j<index){
                            index=i+j;
                        }
                    }
                }
            }
        }
        System.out.println(index);*/
       System.out.println(min);
        int res=(min-7)/(8*n);
        if(res<100000&&res*(8*n+7)<min){
            res++;
            System.out.println(res);
        }
        if(res<=100000&&res*(8*n+7)>=min){
            System.out.println(res);
        }
        int index=0;
        if(res>100000){
            index=((res-100000)*(8*n+7)-3)/(4*n);
            if(index*(4*n+3)<min){
                index++;
            }
        }
        System.out.println(res+index);
    }
}
