package gittub;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        //暴力法
        //785ms 62.3MB
        if(headA==null||headB==null){
            //若有一个链表为空，则不可能有相交
            return null;
        }
        ListNode curA=headA;
        ListNode curB=headB;
        for(;curA!=null;curA=curA.next){
            curB=headB;
            for(;curB!=null;curB=curB.next){
                if(curA==curB){
                    return curA;
                }
            }
        }
        return null;
    }
    /*public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //745 48.6
        if(headA==null||headB==null){
            //若有一个链表为空，则不可能有相交
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
    }*/

    //public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //1ms 49.1MB
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


      /*  if(headA==null||headB==null){
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
    }*/
}
