package BinaryTree;

public class ifSameTree {
    public boolean sameTree(Node root1,Node root2){
        if(root1==null&&root2==null){
            return true;
        }
        if(root1==null||root2==null){
            return false;
        }
        if(root1.value!=root2.value){
            //此处不能判断若相等则返回true,否则无法后序的判断
            return false;
        }
        return sameTree(root1.left,root2.left)&&sameTree(root1.right,root2.right);
    }
}
