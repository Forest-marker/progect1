package 链表;

public class FindKthToTail {
    /*public static int len(ListNode head){
        ListNode cur=head;
        int count=0;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }


    public static ListNode findKthToTail(ListNode head,int k){
        int count=len(head);
        if(head==null||k>count){
            return null;
        }
        if(k==count){
            return head;
        }
        ListNode cur=head;
        for(int i=0;i<count-k;i++){
            cur=cur.next;
        }
        return cur;
    }*/

    //法二
    //前后引用
    public static ListNode Find(ListNode head,int x){
        ListNode front=head;
        ListNode back=head;
        for(int i=0;i<x;i++){
            if(back==null){
                return null;
            }
            back=back.next;
        }
        while(back!=null){
            back=back.next;
            front=front.next;
        }
        return front;

    }

}
