package DayOverDay_parctice.DayEleven;

import java.math.BigInteger;
import java.util.*;
import java.math.BigInteger;
public class Main2 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String N=scanner.next();
        char[] chars=N.toCharArray();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(0);
        }
        for(int i=0;i<chars.length;i++){
            list.set(chars[i]-'0',list.get(chars[i]-'0')+1);
        }
        for(int i=0;i<list.size();i++){
            if(list.get(i)>0){
                System.out.println(i+":"+list.get(i));
            }
        }

    }
}
