package Homework;

import java.util.LinkedList;
import java.util.List;

class ListNode{
    ListNode next;
    int val;
    ListNode(int x,ListNode next){
        val=x;
        this.next=next;
    }
}
public class DayTwoEleven {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //参考评论，此方法很独特
        //通过while循环将两个链表长度的差距消除完毕
        /*例如示例一：4 1 8 4 5 null 5 0 1 8
                     5 0 1 8 4 5 null 4 1 8
                     即返回指向8的引用*
              示例二：0  9 1  2   4 null 3 2
                     3  2 4 null 0   9  1 2
                     即返回指向2的引用*/
        //此处注意是引用的指向相同，而不是单纯的元素相同
        //除此之外。若是两个链表长度相同，没有交点，则一次while循环就可以valA==valB结束
        //若是两个链表长度不同，没有交点，则会在第二次while循环完毕，以valA==valB结束


       if(headA==null||headB==null){
            //若有一个链表为空，则不可能有相交
            return null;
        }
        ListNode valA=headA;
        ListNode valB=headB;
        while(valA!=valB){
            valA=valA==null?headB:valA.next;
            valB=valB==null?headA:valB.next;
        }
        return valA;
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(5,null);
        ListNode node2=new ListNode(4,node1);
        ListNode node3=new ListNode(8,node2);
        ListNode node4=new ListNode(1,node3);
        ListNode node5=new ListNode(4,node4);//头结点

        ListNode n6=new ListNode(5,null);
        ListNode n5=new ListNode(4,node1);
        ListNode n4=new ListNode(8,node2);
        ListNode n3=new ListNode(1,node3);
        ListNode n2=new ListNode(0,n3);
        ListNode n1=new ListNode(5,n2);

        ListNode res=getIntersectionNode(node5,n1);
        System.out.println(res.val);




    }
}
