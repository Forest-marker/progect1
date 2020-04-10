package DayOverDay_parctice.DayNine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        StringBuilder str=new StringBuilder();
        //String str1="";
        //123 123%10=3 123/10=12 12%10=2 12/10=1 1%10=1 1/10=0
        while(m>0){
            str.append(m%10);
            //str1=str1+String.valueOf(m%10);
            m/=10;
        }
        System.out.println(str.toString());
    }
}
