package DayOverDay_parctice.DayNine;

class Person{
    String name="no name";
    public Person(String m){
        name=m;
    }
}
class E extends Person{
    String eid="0000";
    public E(String id){
        super("m");
        eid=id;
    }
}
public class Test {
    public static void main(String[] args) {
        E e=new E("123");
        System.out.println(e.eid);
    }
}
