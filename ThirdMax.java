package gittub;

import java.util.TreeSet;

public class ThirdMax {

    //法一：
    /* public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        //刚开始只排序，然后输出，没有考虑到重复的问题加栈将重复元素去掉
       Stack<Integer> stack=new Stack<>();
       for(int a:nums){
           if(stack.isEmpty()){
               stack.push(a);
           }else{
               //压入不重复元素
               if(stack.peek()!=a){
                   stack.push(a);
               }
           }
       }
       if(stack.size()<3){
           return stack.pop();
       }else{
           stack.pop();
           stack.pop();
           return stack.pop();
       }
    }
    */

    //法二

    //利用红黑树
    public int thirdMax(int[] nums) {
        TreeSet<Integer> tree=new TreeSet<>();
        for(int s:nums){
            //添加元素自动排序
            tree.add(s);
            if(tree.size()>3){
                tree.remove(tree.first());
            }
        }
        //first()获取最小元素，last()获取最大元素
        return tree.size()>=3?tree.first():tree.last();
    }

}
