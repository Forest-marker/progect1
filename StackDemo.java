package bitekeji;

import java.util.Stack;

/*public class StackDemo {

    public static boolean stack(String str){
        Stack<Character> list=new Stack<>();
        char a[][]={{'(',')'},{'[',']'},{'{','}'}};
        //int flag=0;
        for(int i=0;i<str.length();i++){
            int flag=0;
            char cur=str.charAt(i);
            for(int j=0;j<3;j++){
                if(str.charAt(i)==a[j][0]){
                    list.push(str.charAt(i));
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                if(list.isEmpty()){
                    return false;
                }
                char top=list.pop();
                for(int k=0;k<a.length;k++){
                    if(top==a[k][0]){
                        if(cur==a[k][1]){
                            break;
                        }else{
                            return false;
                        }
                    }

                }
            }
        }
        return list.isEmpty();
    }
    public static void main(String[] args){
        String str="()(()){}";
        System.out.println(stack(str));
    }
}
*/
public class StackDemo{
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        while(!stack.isEmpty()){
           // System.out.println();
            //去除栈顶元素不删除
            System.out.println(stack.peek());
            //去除栈顶元素并删除
            System.out.println(stack.pop());
        }
    }


}