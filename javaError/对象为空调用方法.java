package javaError;

public class 对象为空调用方法 {
    //这里如果hello()是个普通实例方法的话就选D了，
    // 可是hello()是静态方法，不需要对象也可以调用。记住就是了。
    public static void hello() {
        System.out.println("hello");
    }

    public void hello1() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        对象为空调用方法 test=null;
        test.hello();//输出hello,能编译通过，并正确运行
        test.hello1();//Exception in thread "main" java.lang.NullPointerException
        //能编译通过，但因变量为null，不能正常运行
    }
}

