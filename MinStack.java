package Stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    MinStack(){
        stack=new Stack<>();
        minStack=new Stack<>();
    }
    public void push(int x){
        stack.push(x);
        if(minStack.isEmpty()||x<=minStack.peek()){
            minStack.push(x);
        }

    }
    public int pop(){
        //包装类涉及对象引用
        //比较内容而不是引用
        int ret=stack.peek();
        //自动拆箱
        if(ret==minStack.peek()){
            minStack.pop();
        }
        //错误
        /*if(stack.peek().equals(minStack.peek())){
            minStack.pop();
        } */
        return stack.pop();
    }
    public int getMin(){

        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack p=new MinStack();
        p.push(1);
        p.push(-1);
        p.push(-3);
        p.push(-1);
        p.push(-3);

        System.out.println(p.pop());
        System.out.println(p.getMin() );
    }
}
