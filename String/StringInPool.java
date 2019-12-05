package String;

public class StringInPool {
    public static void main(String[] args){
       /* String s="hello";
        String p="hello";
        String q="hello";
        //判断引用是否指向同一个对象
        System.out.println(s==p);
        System.out.println(p==q);
        //判断字符串是否相等
        System.out.println(s.equals(p));
        System.out.println(s.equals(q));
        System.out.println("===========");

        String r="hello";
        String h=new String("hello");
        String k=new String("hello");
        //判断引用是否指向同一个对象
        System.out.println(r==k);
        System.out.println(r==h);
        System.out.println(k==h);
        //判断字符串是否相等
        System.out.println(r.equals(h));
        System.out.println(r.equals(h));
        System.out.println(h.equals(k));
        System.out.println("===========");
        String j="hello"+" "+"world";
        String l="hello world";
        //对象
        System.out.println(j==l);
        System.out.println(j.equals(l));*/


        System.out.println("===========");
        String s="hello";
        String p=new String(s);
        //intern()
        p=p.intern();
        System.out.println(s==p);



    }

}
