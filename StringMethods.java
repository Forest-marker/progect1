package String;

import java.io.UnsupportedEncodingException;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringMethods {
    private static byte[] transform(byte[] b,String fromCharset,String toCharset)throws UnsupportedEncodingException{
        String s=new String(b,fromCharset);
        return s.getBytes(toCharset);
    }
    private static boolean isNumber(String s){
        for(char c:s.toCharArray()){
            if(c<'0'||c>'9'){
                return false;
            }
            //判断是否数字字符
            /*if(!Character.isDigit(c)){
                return false;
            }*/
        }
        return true;
    }
    private static int compareTo( String str1,String str2){
        int i=str1.length();
        int j=str2.length();
        int min=0;
        if(i<j){
           min=i;
        } else{
            min=j;
        }
        for(int k=0;k<min;k++){
            if(str1.charAt(k)<str2.charAt(k)){
                return -1;
            }
            if(str1.charAt(k)>str2.charAt(k)){
                return 1;
            }
        }
        //上面防止下标越界，进行了小长度比较
        //所以此处相等时要判断哪个更大
        if(i>j){
            return 1;
        }else if(i<j){
            return -1;
        }else{
            return 0;
        }
    }
    public static boolean contain(String s1,String s2){
        //13 ge 6 ge j<7 i=6 i<12
        int count=0;
        if(s1.length()==s2.length()){
            for(int i=0;i<s1.length();i++){
                if(s1.charAt(i)==s2.charAt(i)){
                    count++;
                }
            }
            if(count==s2.length()){
                return true;
            }
            return false;
        }
        for(int j=0;j<s1.length()-s2.length();j++){
            count=0;
            int k=0;
           for(int i=j;i<j+s2.length();i++){
               if(s1.charAt(i)==s2.charAt(k++)){
                   count++;
               }
           }
           System.out.println(count);
           if(count==s2.length()){
               return true;
           }
        }
        return false;

    }
    //实现方法 indexOf, 能够找出字符串子串存在的位置
    private static int indexOf(String s1,String s2){
        int count=0;
        if(s1.length()==s2.length()){
            for(int i=0;i<s1.length();i++){
                if(s1.charAt(i)==s2.charAt(i)){
                    count++;
                }
            }
            if(count==s2.length()){
                return 0;
            }
            return -1;
        }
        //abcd  d j=0 j<=3 i=0 0<1 1<2 2<3     3<4 4<5
        //5 2 <=3 2<4 3<5
        for(int j=0;j<=s1.length()-s2.length();j++){
            count=0;
            int index=0;
            for(int i=j;i<j+s2.length();i++){
                if(s1.charAt(i)==s2.charAt(i)){
                    index=j;
                    count++;
                }
            }
            if(count==s2.length()){
                return index;
            }
        }
        return -1;
    }
    public static void replaceAll(String s,char s1,char s2){
        char[] arr=s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(arr[i]==s1){
                arr[i]=s2;
                break;
            }
        }
        System.out.println(Arrays.toString(arr));

    }

    public static String[] split(String str,String flag){
        List<String> list=new ArrayList<>();
        String[] arr;
        while(str.contains(flag)){
            int index=str.indexOf(flag);
            String tmb=str.substring(0,index);
            list.add(tmb);
            str=str.substring(index+flag.length());
        }
        //单独处理最后一个遗留的字符串
        list.add(str);
        arr=new String[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }
        return arr;
    }

    public static void main(String[] args)throws UnsupportedEncodingException{
        /*byte[] s="中国人".getBytes("GB18030");
        for(byte b:s){
            System.out.printf("\\x%x", b);
        }
        System.out.println();

        byte[] p=transform(s,"GB18030","UTF-8");
        for(byte b:p){
            System.out.printf("\\x%x",b);
        }
        System.out.println(isNumber("ab123cdkk"));
        System.out.println(isNumber("bj1lkj11"));
        System.out.println("=======");
        System.out.println(isNumber("12344"));
        System.out.println("=======");
        System.out.println("abc".compareTo("bbc")); // < 0 -1
        System.out.println("abc".compareTo("abcd"));    // < 0 -1
        System.out.println("abc".compareTo("bbcd"));    // < 0 -1
        System.out.println("bbcd".compareTo("abc"));    // >0 1*/
        //String a="abc";
        /*System.out.println(a.length());
        System.out.println(compareTo("abc","bbc"));//-
        System.out.println(compareTo("abc","abcd"));//-
        System.out.println(compareTo("abcd","abc"));//+
        System.out.println(compareTo("abc","bbcd"));//-
        System.out.println(compareTo("bbcd","abc"));//+
        System.out.println(compareTo("abc","abc"));*/
       /* System.out.println(indexOf("abcd","abc"));
        System.out.println(indexOf("abc","abc"));
        System.out.println(indexOf("abcd","a"));
        System.out.println(indexOf("abcd","d"));//false
        //System.out.println(indexOf("helloworld","world"));*/




    }
}
