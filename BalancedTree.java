package BinaryTree;

public class BalancedTree {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int left=getheight(root.left);
        int right=getheight(root.right);
        return Math.abs(left-right)<2&&isBalanced(root.left)&&isBalanced(root.right);
    }
    public int getheight(TreeNode root){
        return root==null?0:Math.max(getheight(root.left),getheight(root.right))+1;
    }
}
