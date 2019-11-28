package 链表;

public class Copy {
    public static ListNode copy(ListNode head){
        ListNode newHead=null;
        ListNode newLast=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode node=new ListNode(cur.val);
            if(newHead==null){
                newHead=node;
            }else{
                newLast.next=node;
            }
            newLast=node;
            cur=cur.next;
        }
        return newHead;
    }
}
