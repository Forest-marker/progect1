package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Balance {
    public static int balancedStringSplit(String s){
        List<Character> list=new ArrayList<>();
        int count=0;
        for(char c:s.toCharArray()){
            if(list.size()==0){
                list.add(c);
            }else{
                //注意此处栈顶下标为list.size()-1
                if(c==list.get(list.size()-1)){
                    list.add(c);
                }else{
                    list.remove(list.size()-1);
                    if(list.isEmpty()){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String s="LRLRLR";
        System.out.println(balancedStringSplit(s));
    }
}
