package javaError;

/*
编译出错
分析：由于Derived继承了Base类，生成Derived对象时也要先调用Base的构造方法。
Derived只有唯一的构造方法，且在这个构造方法中没有显示地调用父类构造方法，
所以会调用默认构造方法，而base又没有默认构造方法，所以会出错。
*/
/*class Base{
    public Base(String s){
        System.out.print("B");
    }
}
public class 子类父类的构造方法 extends Base{
    public 子类父类的构造方法 (String s) {
        System.out.print("D");
    }
    public static void main(String[] args){
        new 子类父类的构造方法 ("C");
    }
}*/
