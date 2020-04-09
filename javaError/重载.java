package javaError;

public class 重载 {

    /*
   针对同一个类:
  方法名相同
  方法的参数不同(参数个数或者参数类型)
  方法的返回值类型不影响重载
     */
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int ret = add(a, b);
        System.out.println("ret = " + ret);
    }
    //当两个方法的名字相同, 参数也相同, 但是返回值类型不同的时候, 不构成重载
    public static int add(int x, int y) {
        return x + y;
    }
    /*public static double add(int x, int y) {
        return x + y;
    }*/
    /*public static double add(int x, int y) {
        return x + y+1;
    }*/
    public static double add(int x) {
        return x ;
    }
    public static double Add(int x, int y) {
        return x + y;
    }
}
