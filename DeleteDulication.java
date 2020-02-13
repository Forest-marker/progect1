package gittub;

class Node{
    Node next;
    int val;
    Node(int val){
        this.val=val;
        next=null;
    }
    Node(int val,Node next){
        this.val=val;
        this.next=next;
    }
}
public class DeleteDulication {
    public static Node deleteDulication(Node head){
        if(head==null){
            return head;
        }
        Node prev=new Node(0);
        Node fack=prev;
        prev.next=head;
        Node cur=head;
        Node next=head.next;
        while(next!=null){
            if(cur.val!=next.val){
                prev=prev.next;
                cur=cur.next;
                next=next.next;
            }else{
                while(next!=null&&cur.val==next.val){
                    next=next.next;
                }
                prev.next=next;
                cur=next;
                if(next!=null){
                    next=next.next;
                }
            }
        }
        return fack.next;
    }
}
