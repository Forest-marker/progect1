package BinaryTree;

public class ifSubTree {
    public boolean isSameTree(Node p,Node q){
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        return p.value==q.value&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
    public boolean isSubtree(Node s,Node t){
        //此题与上一题不同的是，除过判断子树是否是其分支的完全部分
        //还要判断子树的根结点是否大树的结点之一
        //此题：遍历一个结点看是否子树完全相同
        if(s==null){
            return false;
        }
        //完全相同的两棵树，自然也是子树
        if (isSameTree(s, t)) {
            return true;
        }
        if(isSubtree(s.left,t)){
            return true;
        }
        return isSubtree(s.right,t);

    }
    public boolean isSubtree2(Node s,Node t){
        if(t==null) return true;
        if(s==null) return false;
        //先找到一个相同的结点

        if(s.value!=t.value){
            //先找到引用完全相同
            return isSubtree(s.left,t) || isSubtree(s.right,t);
        }
        else{
            //找到相同的结点引用
            //s.val == t.val
            //后面的isSubtree还要判断是因为可能一个树中有值相同的结点
            //而前面不需要是每个值都遍历了的，所有不必要
            return isSameTree(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
        }

    }
}
