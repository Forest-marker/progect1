package javaError;

public class 静态块构造块 {
    /*
    分析：这道题猛地一看可能会new了三个对象，那肯定先输出一个静态块后跟三个构造块了。
    可事情并不是这么绝对，这里的t1,t2两个对象也是静态的，他们在静态块之前执行。
    所以出现了先有两个构造块，再有一个静态块。
    最后的构造块是main里的对象t初始化时输出的。
     */
    public static 静态块构造块 t1 = new 静态块构造块();
    public static 静态块构造块 t2 = new 静态块构造块();
    {
        System.out.println("construct block");
    }
    static
    {
        System.out.println("static block");
    }
    public static void main(String[] args) {
        静态块构造块 t = new 静态块构造块();
    }
    /*
    construct block
    construct block
    static block
    construct block
     */
}
