package javaError;
/*
使用 extends 指定父类.
Java 中一个子类只能继承一个父类 (而C++/Python等语言支持多继承).
子类会继承父类的所有 public 的字段和方法.
对于父类的 private 的字段和方法, 子类中是无法访问的.
子类的实例中, 也包含父类的实例，可以用super关键字得到父类实例的引用
 */
public class 继承 {
    public String name;
    public 继承(String name) {
        this.name = name;
    }
    public void eat(String food) {
        System.out.println(this.name + "正在吃" + food);
    }
}
class Cat extends 继承 {
    public Cat(String name) {
        // 使用 super 调用父类的构造方法.
        super(name);
    }
}
class Bird extends 继承 {
    public Bird(String name) {
        super(name);
    }
    public void fly() {
        System.out.println(this.name + "正在飞 ︿(￣︶￣)︿");
    }
}
 class T {
    public static void main(String[] args) {
        Cat cat = new Cat("小黑");
        cat.eat("猫粮");
        Bird bird = new Bird("圆圆");
        bird.fly();
    }
}
