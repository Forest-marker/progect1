import javax.print.DocFlavor;
import java.util.Arrays;

public class Template<E, K, V> {
}

class MyArrayList<E>{
    private E[] array;
    private int size;
    private int capacity;

    public MyArrayList(){
        array = (E[]) new Object[10];
        size = 0;
        capacity = 10;
    }
    public void add(E value){
        if(size == capacity){
            array = Arrays.copyOf(array, 2 * capacity);
            capacity *= 2;
        }
        array[size++] = value;
    }

    public E remove(){
        E ret;
        if(size > 0){
            ret = array[size - 1];
            array[size - 1] = null;
            --size;
            return ret;
        }
        else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    public void print()
    {
        for(E e : array){
            System.out.print(e + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        MyArrayList<Integer> mL = new MyArrayList<>();
        MyArrayList<Character> mL2 = new MyArrayList<>();
        mL.add(1);
        mL.add(2);
        mL.add(3);
        mL.add(4);
        mL.print();

        mL2.add('a');
        mL2.add('b');
        mL2.add('c');
        mL2.add('d');
        mL2.print();

    }
}
/* C++定义泛型
template <class T, class T2>
class A{

};

*/

class  List<E>{

}
class MyList<E extends Number>  {
    //静态成员不能定义泛型: 属性和函数
    //private static E e;
    //非静态内部内可以使用外部类的泛型参数
    //静态内部类不能使用外部类的泛型参数，需要自己定义
    private static class Node<E>{
        private E value;
        Node<E> next;
        private Node(E value){
            this.value = value;
            next = null;

        }
    }
    private Node<E> head = null;

    public void pushFront(E value){
        if(head == null){
            head = new Node<>(value);
        }
        else{
            Node<E> node = new Node(value);
            node.next = head;
            head = node;
        }
    }

    public E popFront(){
        E ret = head.value;
        head = head.next;
        return ret;
    }
    // ? : 对类型没有限制
    public static void fun1(MyList<?>  ml)
    {

    }
    // ? extends 类型： 指明类型的上界
    public static void fun2(MyList <? extends Integer> m1)
    {

    }

    //? super 类型： 指明类型的下界， 最低要求
    public static void fun3(MyList <? super Number> m1){

    }
    public static void main(String[] args) {
        //MyList<Integer> ml = new MyList<>();
        //MyList ml = new MyList();
        MyList<Integer> ml = new MyList<>();
        ml.pushFront(1);
        ml.pushFront(2);
        ml.pushFront(3);
        ml.pushFront(4);
        int ret = ml.popFront();

        //MyList<String> m2 = new MyList<>();
        MyList<Number> m3 = new MyList<>();

        // Object超出定义时类型的上界
        //MyList<Object> m4 = new MyList<>();

        fun1(ml);
        fun1(m3);

        fun2(ml);
        //Number 已经超出上界
        //fun2(m3);
        // Integer 不是Number类型的父类或者Number本身
        //fun3(ml);

        fun3(m3);


    }

}

class A implements Comparable<A>{
    @Override
    public int compareTo(A o) {
        return 0;
    }
}

class C{

}

class B<E extends Comparable<E>, T>{
    public static void main(String[] args) {
        B<Integer, Character> b = new B<>();
        B<C, Character> c = new B<>();
        B<A, Character> d = new B<>();
    }
}

