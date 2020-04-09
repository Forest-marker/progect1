package javaError;

public class private实现封装 {
    /*
    在我们写代码的时候经常会涉及两种角色: 类的实现者和类的调用者.
封装的本质就是让类的调用者不必太多的了解类的实现者是如何实现类的, 只要知道如何使用类就行了.
这样就降低了类使用者的学习和使用成本，从而降低了复杂程度
     */
    /*
    被 public 修饰的成员变量或者成员方法, 可以直接被类的调用者使用.
    被 private 修饰的成员变量或者成员方法, 不能被类的调用者使用.
     */
    private String name = "张三";
    private int age = 18;

    public void show() {
        System.out.println("我叫" + name + ", 今年" + age + "岁");
    }
}
class Test {
    public static void main(String[] args) {
        private实现封装 person = new private实现封装();
        person.show();
        /*
        此时字段已经使用 private 来修饰. 类的调用者(main方法中)不能直接使用. 而需要借助 show 方法.
        此时类的使用者就不必了解 Person 类的实现细节.
        同时如果类的实现者修改了字段的名字, 类的调用者不需要做出任何修改(类的调用者根本访问不到 name, age
这样的字段
         */

       // System.out.println("我叫" + person.name + ", 今年" + person.age + "岁");
    }
    final public class Animal {

    }
    //编译出错，被final修饰的类不能被继承
   /* public class Bird extends Animal {

    }*/

}

