package BinaryTree;

//递增顺序查找树
//给定一个树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
public class IncreasingBST {
    //先记录元素，再进行连接
    /*public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList();
        inorder(root, vals);
        TreeNode ans = new TreeNode(), cur = ans;
        for (int v: vals) {
            cur.right = new TreeNode(v);
            cur = cur.right;
        }
        return ans.right;
    }

    public void inorder(TreeNode node, List<Integer> vals) {
        //if (node == null) return;
        if(node!=null){
        inorder(node.left, vals);
        vals.add(node.val);
        inorder(node.right, vals);
        }

    }*/

    //递归
    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode fack=new TreeNode();
        cur=fack;
        inorder(root);
        return fack.right;

    }
    public void inorder(TreeNode node){
        if (node == null) return;
        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inorder(node.right);
    }
}
