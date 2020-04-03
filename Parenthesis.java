package DayOverDay_parctice;

import java.util.Stack;

public class Parenthesis {
    public static boolean chkParenthesis(String A, int n) {
        // write code here
        //合法的括号串 1.只包含括号字符 2.左右括号一一对应
        Stack<Character> stack=new Stack<Character>();
        char[] tmp=A.toCharArray();
        for(int i=0;i<n;i++){
            if(stack.isEmpty()){
                stack.push(tmp[i]);
            }
            else{
                if(stack.peek()=='('&&tmp[i]==')'){
                    stack.pop();
                }else{
                    stack.push(tmp[i]);
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String a="()(()()()";
        System.out.println(chkParenthesis(a,8));
    }
}
