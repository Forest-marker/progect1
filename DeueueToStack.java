package Stack;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DeueueToStack {
    public  Queue<Integer> ll;
    DeueueToStack(){
         ll=new LinkedList<>();
    }
    public  void push(int element){
        ll.offer(element);
    }
    public   int pop(){
        /*int temp=0;
       for(int i=0;i<ll.size();i++){
           temp=ll.poll();
           if(i<ll.size()-1){
               ll.offer(temp);
           }
       }*/
        int size=ll.size();
       while(ll.size()>1){
           ll.offer(ll.poll());
           --size;
       }
       return ll.poll();
    }
    public  int top(){
        int p=0;
        for(int i=0;i<ll.size();i++){
             p=ll.poll();
             ll.offer(p);
        }
        return p;
    }
    public static void main(String[] args) {
        DeueueToStack p=new DeueueToStack();
        p.push(1);
        p.push(2);
        System.out.println(p.top());


    }
}
