package javaError;

public class 向上转型 {
    public static void main(String[] args) {
        /*
        double。
        这其实是一道考察向上转型的题。数据类型上double > int > char。所以最后转换为double。
        如果“A”+a+b则应该为String类型。
         */
        int a=10;
        double b=3.14;
        System.out.println('a'+a+b);
    }
}
