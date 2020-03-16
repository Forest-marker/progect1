package Map;

public class BSTree {
    //二叉搜索树：左子树比根节点的值小，右子树比根节点的值大
    //二叉搜索树的中序遍历是升序序列
    public static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value=value;
            right=left=null;
        }
    }
    private Node root=null;
    public Node find(int value){
        //先于根节点比较，若比根节点小，则在左子树找，比根节点大在右子树找
        if(root==null){
            return null;
        }
        Node cur=root;
        //从根开始搜索
        while(cur!=null){
            if(cur.value==value){
                return cur;
            }else if(cur.value>value){
                //比根节点小
                cur=cur.left;
            }else{
                cur=cur.left;
            }
        }
        //找到则返回，找不到返回null
        return null;
    }

    //插入节点
    public boolean insert(int value){
        if(root==null){
            root=new Node(value);
            return true;
        }
        //非空，首先搜素，再插入
        Node cur=root;
        Node parent=null;
        while(cur!=null){
            parent=cur;
            if(cur.value==value){
                //不能插入重复节点
                return false;
            }else if(cur.value>value){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        //找到一个合适的位置
        cur=new Node(value);
        if(parent.value>cur.value){
            parent.left=cur;
        }else{
            parent.right=cur;
        }
        return true;
    }

    public void inOrder(){
        inOrderInternal(root);
        System.out.println();
    }

    public void inOrderInternal(Node root){
        //中序遍历
        if(root!=null){
            inOrderInternal(root.left);
            System.out.print(root.value+" ");
            inOrderInternal(root.right);
        }
    }

    public boolean remove(int value){
        //移除(删除）元素
        //涉及两个节点的重新连接
        if(root==null){
            return false;
        }
        Node cur=root;
        Node parent=null;
        //此处是找寻耀删除的节点是否存在
        while(cur!=null){
            if(cur.value==value){
                //找到耀删除的节点
                break;
            }else if(cur.value>value){
                parent=cur;
                cur=cur.left;
            }else{
                parent=cur;
                cur=cur.right;
            }
        }
        //cur==null说明在循环内部未找到所要删除的元素
        if(cur==null){
            return false;
        }
        //找到则进行调用删除函数，进行操作
        remove(parent,cur);
        return true;
    }

    public void remove(Node parent,Node cur){
        /*
        共有3种情况
        1.叶子节点
        2.节点的左右节点有一个为空
        3.节点的左右节点都不为空
         */
        if(cur.left==null){
            //2.节点的左节点为空
            //将父节点与该删节点的非空子节点连接
            if(cur!=root){
                //parent.left==cur此处判断父节点的右边还是左边是该删节点
                if(parent.left==cur){
                    parent.left=cur.right;
                }else{
                    parent.right=cur.right;
                }
            }else{
                //此处是特殊情况的考虑，cur为根，则此时因为没有左子树，直接将根的右边与该删节点的右子节点相连接
                root=cur.right;
            }
        }else if(cur.right==null){
            //2.节点的右节点为空
            if(cur!=root){
                if(parent.left==cur){
                    parent.left=cur.left;
                }else{
                    parent.right=cur.left;
                }
            }else{
                root=cur.left;
            }
        }else{
            //1.左右子树都存在
            //1.找到左子树的最右边节点：大于左子树中的其他节点
            //2.或者找到右子树的最左边节点：小于右子树中的其它节点
            //让cur的值和找到的节点的值交换，删除找到的节点
            parent=cur;
            Node next=cur.left;
            //找到最右节点
            while(next.right!=null){
                parent=next;
                next=next.right;
            }
            //把最右边节点的值赋给cur
            cur.value=next.value;
            //删除next
            //此处已经是next的最右边说明此结点没有右节点，剩余只有两种情况，左节点为空，有左节点
            if(parent.left==next){
                parent.left=next.left;
            }else{
                parent.right=next.left;
            }
        }
    }

    public static void main(String[] args) {
        BSTree bst=new BSTree();
        bst.insert(10);
        bst.insert(1);
        bst.insert(0);
        bst.insert(10);
        bst.insert(15);
        bst.insert(2);
        bst.insert(7);
        bst.insert(4);

        bst.inOrder();
        bst.remove(7);
        bst.inOrder();

        bst.remove(2);
        bst.inOrder();

        bst.remove(11);
        bst.inOrder();

    }
}
