package 链表;

//编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前 。
public class Partition {
    public ListNode partition1(ListNode pHead, int x) {
        // write code here
        //总体思路
        //已给定一个头节点，将小于x的结点放在一个小链表中，
        //大于X的结点放在一个大链表中
        //最后将小链表和大链表合并，即小链表的最后一个结点的下一个为大链表的头结点，实现两个链表的连接
        //设置一个假结点newHead1作为小链表的头结点，将尾结点newLast1指向头节点
        //设置一个假结点newHead2作为大链表的头结点，将尾结点newLast2指向头节点
        ListNode newHead1=new ListNode(0);
        ListNode newHead2=new ListNode(0);
        ListNode newLast1=newHead1;
        ListNode newLast2=newHead2;
        ListNode cur=pHead;
        //后期分别往两个大小链表插入时，直接利用尾节点变化，相当于把一个新节点尾插

        while(cur!=null){
            if(cur.val<x){
                newLast1.next=cur;
                newLast1=cur;
            }else{
                newLast2.next=cur;
                newLast2=cur;
            }
            cur=cur.next;
        }
        //因为头结点是假结点，无效，所以大链表实际头结点是头结点（假结点）的下一个
        newLast1.next=newHead2.next;

        newLast2.next=null;
        //返回小链表的真正头结点（假头结点的下一个）
        return newHead1.next;
    }

    //方法二
    public static ListNode  partition2(ListNode head,int x){
        ListNode newHead1=null;
        ListNode newHead2=null;
        ListNode newLast1=null;
        ListNode newLast2=null;
        ListNode cur=head;
        while(cur!=null){
            if(cur.val<x){
                if(newHead1==null){
                    newHead1=cur;
                }else{
                    newLast1.next=cur;
                }
                newLast1=cur;
                cur=cur.next;
            }
            else{
                if(newHead2==null){
                    newHead2=cur;
                }else{
                    newLast2.next=cur;
                }
                newLast2=cur;
                cur=cur.next;
            }
        }

        if(newHead2==null){
            return newHead1;
        }
        if(newHead1==null){
            return newHead2;
        }
        newLast1.next=newHead2;
        newLast2.next=null;
        return newHead1;
    }
}
