package gittub;

public class EndOfFirstHalf {
    public static  Node endOfFirst(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        //1 2 3 4 
        Node p4=new Node(4,null);
        Node p3=new Node(3,p4);
        Node p2=new Node(2,p3);
        Node p1=new Node(1,p2);
        Node res=endOfFirst(p1);
        System.out.println(res.val);
    }
}
