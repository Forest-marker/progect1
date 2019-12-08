package Stack;

import java.util.Stack;

public class StackToQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    StackToQueue(){
        stack1=new Stack<Integer>();
        stack2=new Stack<Integer>();
    }
    public void offer(int element){
        stack1.push(element);
    }
     public int poll(){
        if(stack2.isEmpty()){
            int sz=stack1.size();
            for(int i=0;i<sz;i++){
                stack2.push(stack1.pop());
            }
        }
        //stack2.pop();
        return stack2.pop();
     }
    public int top(){
        if(stack2.isEmpty()){
            int sz=stack1.size();
            for(int i=0;i<sz;i++){
                stack2.push(stack1.pop());
            }
        }
       // stack2.peek();
        return stack2.peek();
    }

    public static void main(String[] args) {
        StackToQueue p=new StackToQueue();
        p.offer(1);
        p.offer(2);
        System.out.println(p.top());
        System.out.println(p.poll());
    }
}
