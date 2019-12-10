package Stack;

import java.util.Stack;

public class backspaceCompare {
    Stack<Character> stack1;
    Stack<Character> stack2;
    backspaceCompare(){
        stack1=new Stack<>();
        stack2=new Stack<>();
    }
    public boolean spaceCompare(String S, String T) {
        for(char c:S.toCharArray()){
            if(c!='#'){
                stack1.push(c);
            }
            if(c=='#'&&!stack1.isEmpty()){
                stack1.pop();
            }
        }
        for(char c:T.toCharArray()){
            if(c!='#'){
                stack2.push(c);
            }
            if(c=='#'&&!stack2.isEmpty()){
                stack2.pop();
            }
        }
        if(stack1.size()!=stack2.size()){
            return false;
        }
        else{
            int sz=stack1.size();
            while(sz>0){
                if(stack1.pop()!=stack2.pop()){
                    return false;
                }
                sz--;
            }
        }
        return true;
        // return stack1==stack2;




    }
}
