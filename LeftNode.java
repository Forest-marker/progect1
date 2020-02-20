package BinaryTree;

public class LeftNode {
    static int size=0;
    public void getLeafSize1(Node root){
        //递归实现
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            size++;
            return;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }

    public int getLeafSize2(Node root){
        //因为是递归，子树再到子树，会到最后一排结点，
        // 只需要考虑是空还是叶子结点，依次向上返回，完成一次次递归
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        //叶子结点个数等于左子树结点的个数+右子树结点的个数
        return getLeafSize2(root.left)+getLeafSize2(root.right);
    }
}
