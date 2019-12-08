package Stack;

import java.util.Arrays;

public class MyStack {
    int[] array;
    int size;
    MyStack (){
        array=new int[10];
        size=0;
    }
    public void push(int element){
        if(size==array.length){
            array=Arrays.copyOf(array,2*array.length);
        }
        array[size++]=element;
    }
    public void pop(){
        if(size>0){
            --size;
        }
    }
    public int peek(){
        return array[size-1];
    }
    public boolean empty(){
        return size==0;
    }
    public int size(){
        return size;
    }

    public static void main(String[] args) {
        MyStack p=new MyStack();
        p.push(0);
        p.push(1);
        p.push(2);
        p.push(3);
        System.out.println(p.empty() );
        System.out.println(p.size());
        System.out.println(p.peek());
        while(!p.empty()){
            System.out.println(p.peek());
            p.pop();
        }
        System.out.println(p.empty());
    }
}
