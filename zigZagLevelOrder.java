package twoHundreds;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class zigZagLevelOrder {
    // 二叉树的锯齿形层次遍历
    //给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new LinkedList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        int count=0;
        if(root!=null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            int size=queue.size();
            count++;
            List<Integer> buf=new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode node=queue.remove();
                if(count%2==0){
                    ((LinkedList<Integer>) buf).addFirst(node.val);
                }else{
                    ((LinkedList<Integer>) buf).addLast(node.val);
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            list.add(buf);
        }
        return list;
    }
}
