package BinaryTree;

public class FindNode {
    public Node find(Node root,int x){
        if(root==null){
            return root;
        }
        if(root.value==x){
            return root;
        }
        Node node=find(root.left,x);
        if(node!=null){
            return node;
        }
        return find(root.right,x);
    }
}
