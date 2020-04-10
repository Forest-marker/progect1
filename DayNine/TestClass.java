package DayOverDay_parctice.DayNine;

public class TestClass {
    private static void testmethod(){
        System.out.println("r");
    }
    //private 修饰方法
    public static void main(String[] args) {
        ((TestClass)null).testmethod();
        String x="fmn";
        x.toUpperCase();
        System.out.println(x);
        String y=x.replace('f','F');
        System.out.println(y);
        y=y+"wxy";
        System.out.println(y);
        int i=0;
        Integer j=new Integer(0);
        System.out.println(i==j);
        System.out.println(j.equals(i));
    }
}
