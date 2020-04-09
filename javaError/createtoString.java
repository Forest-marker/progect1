package javaError;
/*
toString 方法会在 println 的时候被自动调用.
将对象转成字符串这样的操作我们称为 序列化.
toString 是 Object 类提供的方法, 我们自己创建的 Person 类默认继承自 Object 类, 可以重写 toString 方法实
现我们自己版本的转换字符串方法. .
@Override 在 Java 中称为 "注解", 此处的 @Override 表示下面实现的 toString 方法是重写了父类的方法
 */
public class createtoString {
    private String name;
    private int age;
    public createtoString(String name,int age) {
        this.age = age;
        this.name = name;
    }
    public void show() {
        System.out.println("name:"+name+" " + "age:"+age);
    }
    //重写Object的toString方法
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public static void main(String[] args) {
        createtoString person = new createtoString("caocao",19);
        person.show();
        System.out.println(person);
    }
}

