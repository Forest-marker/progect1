package DayOverDay_parctice.DayFour;

import java.util.HashMap;

public class String0rStringBuffer {
    public static void main(String[] args) {
        String str1="hello";
        String str2="pp";
        operate1(str1,str2);
        System.out.println(str1+" "+str2);

        StringBuffer a=new StringBuffer("hello");
        StringBuffer b=new StringBuffer("pp");
        operate2(a,b);
        System.out.println(a+" "+b);

        String s;
        //没有被初始化，不能编译成功
        //System.out.println("s="+s);

        HashMap<Integer,Integer> map=new HashMap<>();

    }
    public static void operate1(String a,String b){
        //a="h";
        a=new String("h");
        //形参的改变不影响实参
        b="p";
    }
    public static void operate2(StringBuffer a,StringBuffer b){
        //  1. 通过引用修改对象是可以影响对象的   2. 直接修改形参是不会影响实参的
        //a=new StringBuffer("h");
        //在String中使用"+"来进行字符串连接，但是这个操作在StringBuffer类中需要更改为append()方法：
        a.append("kk");//此处会改变，其余都不变
        //b=new StringBuffer("p");
        b=a;
    }
}
