package twoHundreds;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
 //二叉树的层次遍历 II
//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class LevelOrderBottom {
    /*public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> list=new LinkedList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> tlist=new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode node=queue.remove();
                tlist.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                    }
                if(node.right!=null){
                    queue.add(node.right);
                    }
            }
            list.addFirst(tlist);
        }
        return list;
    }*/
    public List<List<Integer>> list=new LinkedList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root){
        dfs(root,0);
        Collections.reverse(list);
        return list;
    }
    public void dfs(TreeNode root,int step){
        if(root==null){
            return;
        }
        if(list.size()<=step){
            list.add(new LinkedList<>());
        }
        dfs(root.left,step+1);
        dfs(root.right,step+1);
        list.get(step).add(root.val);
    }
}
