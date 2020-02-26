package BinaryTree;

 //根据二叉树创建字符串
//你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
//空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。

public class Tree2str {
    public String tree2str(TreeNode t) {
        //子结点要用括号表示例如root(left)(right) 若left为空则为root()right,若right为空则可以省略
        //若left right都为空则都可以省略
        //思路：四种情况
        //1.本身结点为空 返回空
        //2.左右结点都为空，则只有此结点本身
        //3.右节点为空，则是根节点（左子树）
        //4.左右结点都不为空根节点（左子树）（右子树）
            if(t==null)
                return "";
            if(t.left==null && t.right==null)
                return t.val+"";
            if(t.right==null)
                return t.val+"("+tree2str(t.left)+")";
            return t.val+"("+tree2str(t.left)+")("+tree2str(t.right)+")";
        }

    }

