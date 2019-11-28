package 链表;

public class MiddleNode {

    public static int len(ListNode head){
        ListNode cur=head;
        int count=0;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }
    public static ListNode middleNode1(ListNode head){
        if(head==null){
            return null;
        }
        int n=len(head)/2;
        ListNode cur=head;
        for(int i=0;i<n;i++){
            cur=cur.next;
        }
        return cur;
    }

    //快慢引用，都从起点开始，一个一步，判断是否到达终点，没有就再走一步，另一个再走一步，依次循环，直到快的到达
    public static ListNode middleNode2(ListNode head2){
        if(head2==null){
            return null;
        }
        ListNode Fast=head2;
        ListNode Slow=head2;
        while(Fast!=null){
            Fast=Fast.next;
            if(Fast==null){
                break;
            }
            Fast=Fast.next;
            Slow=Slow.next;
        }
        return Slow;
    }
}
