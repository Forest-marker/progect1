package Homework;

import java.util.Stack;

import static java.lang.Integer.parseInt;

public class practice {
    public static int evalRPN(String[] tokens) {
        int a, b;
        Stack<Integer> stack = new Stack<Integer>();
        for(String s : tokens) {
            if(s!="+"&&s!="-"&&s!="*"&&s!="/"){
                stack.push(Integer.parseInt(s));
            }
            else if(s.equals("+")) {
                stack.add(stack.pop() + stack.pop());
            }else if(s.equals("/")) {
                b = stack.pop();
                a = stack.pop();
                stack.add(a / b);
            }else if(s.equals("*")) {
                stack.add(stack.pop() * stack.pop());
            }else if(s.equals("-")){
                b = stack.pop();
                a = stack.pop();
                stack.add(a - b);
            }
        }
        return stack.pop();
    }
    /*
    class Solution {
    public int evalRPN(String[] tokens) {
     int a, b;
        Stack<Integer> stack = new Stack<Integer>();
        for(String s : tokens) {
        	if(s.equals("+")) {
        		stack.add(stack.pop() + stack.pop());
        	}else if(s.equals("/")) {
        		b = stack.pop();
        		a = stack.pop();
        		stack.add(a / b);
        	}else if(s.equals("*")) {
        		stack.add(stack.pop() * stack.pop());
        	}else if(s.equals("-")) {
        		b = stack.pop();
        		a = stack.pop();
        		stack.add(a - b);
        	}else {
        		stack.add(Integer.parseInt(s));
        	}
        }
        return stack.pop();
    }
}*/
    public static void main(String[] args) {
        String[] a={"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
       // System.out.println(parseInt(a[0]));
       //System.out.println(Integer.parseInt(a[1]));
       System.out.println(evalRPN(a));
    }
}



