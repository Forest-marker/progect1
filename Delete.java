package DayOverDay_parctice.DayThree;

import java.util.Scanner;

public class Delete {
    public static String delete(String a,String b){
        StringBuilder str=new StringBuilder();
        String[] tmp=new String[a.length()];
        char[] a1=a.toCharArray();
        char[] b1=b.toCharArray();
        for(int i=0;i<b.length();i++){
            for(int j=0;j<a.length();j++){
                if(b1[i]==a1[j]){
                    tmp[j]="false";
                }
            }
        }
        for(int i=0;i<a.length();i++){
            if(tmp[i]!="false"){
                str.append(a1[i]);
            }
        }
        return str.toString();
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String a=scanner.nextLine();
        String b=scanner.nextLine();
        System.out.println(delete(a,b));
    }
}
