package javaError;

public class staticFinal {
    String name;
    int age;
    static int count;//类变量也叫静态变量，编译时已经产生，属于类本身，且只有一份。存放在方法区
    final int sum=9;//被final修饰的叫常量，也属于对象。 被final修饰，后续不可更改
    static final int a=10;//静态的常量，属于类本身，只有一份 被final修饰，后续不可更改
    public static void print(){
        count++;
        System.out.println("print");
        count++;
    }
    public void show(){

    }

    public static void main(String[] args) {
        staticFinal p=new staticFinal();
        p.print();
        staticFinal.print();
        System.out.println(count);
    }
}
