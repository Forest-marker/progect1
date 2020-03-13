package Map;
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
public class copyRandomList {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node cur=head;
        while(cur!=null){
            Node node=new Node();
            node.val=cur.val;
            node.next=cur.next;
            cur.next=node;
            cur=node.next;
        }
        //处理random
        cur=head;
        while(cur!=null){
            if(cur.random!=null){
                cur.next.random=cur.random.next;
            }
            cur=cur.next.next;
        }
        //拆除过程
        cur=head;
        Node nHead=head.next;
        while(cur!=null){
            Node node=cur.next;
            cur.next=node.next;
            if(node.next!=null){
                node.next=node.next.next;
            }
            cur=cur.next;
        }
        return nHead;
    }

}
