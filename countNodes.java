package BinaryTree;

public class countNodes {
    public static int size=0;
    public void getSize(Node root){
        //利用前序 后序 中序遍历可找到树的长度
        if(root!=null){
            getSize(root.left);
            size++;
            getSize(root.right);
        }
    }


    //就是把一个原文题划分为几个子问题
    public int  getSize2(Node root){
        //结点个数等于根节点+左子树结点个数+右子树结点个数
        if(root==null){
            return 0;
        }
        if(root.right==null&&root.left==null){
            return 1;
        }
        return getSize2(root.left)+getSize2(root.right)+1;
    }

    public Node buildTree(){
        Node root=new Node('1');
        Node node1=new Node('2');
        Node node2=new Node('3');
        Node node3=new Node('4');
        Node node4=new Node('5');
        Node node5=new Node('6');
        Node node6=new Node('7');
        Node node7=new Node('8');
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node4.right = node7;
        return root;
    }

    public static void main(String[] args) {
        countNodes tree=new countNodes();
        Node root=tree.buildTree();
        tree.getSize(root);
        System.out.println(countNodes.size);



    }
}
