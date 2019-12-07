package bitekeji;

public class MyArrayList<E> {
    private E[] array;
    int size;
    MyArrayList(){
        array=(E[])new Object[10];
        size=0;
    }
    public void add(E element){

        array[size++]=element;
    }
    public E remove(){
        E element=array[size-1];
        array[--size]=null;
        return element;
    }

    @Override
    public String toString() {
        return String.format("%s",this.array[size-1]);
    }

    public static void main(String[] args) {
        MyArrayList<String> str=new MyArrayList<>();
        str.add("hello");
        str.add("world");
        str.add("lii");
        str.remove();
        System.out.println(str);
    }
}

