package BinaryTree;

class Node{
    char value;
    Node left;
    Node right;
    public Node(char value){
        this.value=value;
        right=left=null;
    }
}
public class binaryTree {
    //private Node root=null;
    public static int count=0;
    public static void preOrder(Node root){
      //终止条件
        if(root==null){
            return;
        }

      else{
            //递推
            //根
            System.out.print(root.value);
            //左子树
            preOrder(root.left);
            //右子树
            preOrder(root.right);
        }

    }
    public static void inOrder(Node root){
        if(root!=null){
            //访问左子树
            inOrder(root.left);
            //根
            System.out.print(root.value);
            //访问右子树
            inOrder(root.right);
        }
    }

    public static void postOrder(Node root){
        if(root!=null){
            //访问左子树
            postOrder(root.left);

            //访问右子树
            postOrder(root.right);

            //根
            System.out.print(root.value);
        }
    }

    public static void getSize1(Node root){
        if(root!=null){
            getSize1(root.left);
            getSize1(root.right);
            count++;
        }
       // System.out.println(count);
    }

    public static int getSize2(Node root){
        getSize1(root);
        return count;
    }

    public static int getSize3(Node root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        return 1+getSize3(root.left)+getSize3(root.left);
    }

    public void getLeafSize1(Node root){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            count++;
            return;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);

    }

    public static int getLeafSize2(Node root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        return getLeafSize2(root.left)+getLeafSize2(root.right);
    }

    int getKLevelSize(Node root,int k){
        if(root==null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);

    }
    public static Node buildTree(){
        Node root=new Node('A');
        Node node1=new Node('B');
        Node node2=new Node('C');
        Node node3=new Node('D');
        Node node4=new Node('E');
        Node node5=new Node('F');
        Node node6=new Node('G');
        Node node7=new Node('H');
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        node4.right=node7;
        return root;
        }

    public static void main(String[] args) {
        Node root=buildTree();
        /*preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();*/
       getSize1(root);
        binaryTree tree=new binaryTree();
        System.out.println(tree.count);
      // System.out.println(getSize2(root));
        System.out.println(getLeafSize2(root));
    }
}
