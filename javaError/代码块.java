package javaError;

/*
总结：
静态代码块不管生成多少个对象，其只会执行一次，且是最先执行的。
静态代码块执行完毕后, 实例代码块，然后是构造函数
 */
public class 代码块 {
    //普通代码块：定义在方法中的代码块.
    private String name;//实例成员变量
    private int age;
    private String sex;
    private static int count = 0;//静态成员变量 由类共享数据 方法区

    public 代码块() {
        System.out.println("I am Person init()!");
    }

    //实例代码块
    ////构造块：定义在类中的代码块(不加修饰符)。也叫：实例代码块。构造代码块一般用于初始化实例成员变量
    {
        this.name = "bit";
        this.age = 12;
        this.sex = "man";
        System.out.println("I am instance init()!");
    }
    //静态代码块:使用static定义的代码块。一般用来初始化静态成员变量
    static {
        count = 10;//只能访问静态数据成员
        System.out.println("I am static init()!");
    }

    public void show(){
        System.out.println("name: "+name+" age: "+age+" sex: "+sex);
    }

}
 class Main {
    public static void main(String[] args) {
        代码块 p1 = new 代码块();
        代码块 p2 =  new 代码块();
        p1.show();

        //实例代码块优先于构造函数执行。
        /*
        输出：
         I am instance init()!
        I am Person init()!
        name: bit age: 12 sex: man
         */
    }
    /*public static void main(String[] args) {
        { //直接使用{}定义，普通方法块
            int x = 10 ;
            System.out.println("x1 = " +x);
        }
        int x = 100 ;
        System.out.println("x2 = " +x);
        //x1 = 10
        //x2 = 100
    }*/

}
