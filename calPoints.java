package Stack;

import java.util.Stack;

public class calPoints {
    public int calpoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        //遍历字符串
        for (String op: ops){
            //此处注意类型转换，string到int
            if (!op.equals("C") && !op.equals("D") && !op.equals("+"))
                stack.push(Integer.parseInt(op));
            else {
                switch (op){
                    //用size()来定位元素，不用pop()压栈又出栈这么麻烦
                    case "C":
                        stack.pop();
                        break;
                    case "D":
                        stack.push(stack.get(stack.size() - 1) *2);
                        break;
                    case "+":
                        stack.push(stack.get(stack.size() - 1) + stack.get(stack.size() - 2));
                        break;
                }
            }
        }
        //记录栈的数据数量，遍历取出计算总和
        int length = stack.size();
        for (int i = 0; i < length; i++)
            sum += stack.pop();
        return sum;
    }
}
