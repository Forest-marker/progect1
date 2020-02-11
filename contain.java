package gittub;

import java.util.LinkedList;
import java.util.List;


public class contain {

    //利用集合存引用，看引用是否相同，若相同，就说明两链表有相交部分
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Map<Integer,Integer> map=new HashMap<>();
        if(headA==null||headB==null){
            return null;
        }
        List<ListNode> list=new LinkedList<>();
        ListNode curA=headA;
        while(curA!=null){
            list.add(curA);
            curA=curA.next;
        }
        ListNode curB=headB;
        while(curB!=null){
            if(list.contains(curB)){
                return curB;
            }
            curB=curB.next;
        }
        return null;

    }

    }


