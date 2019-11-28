package 链表;

//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode fack = new ListNode(0);
        ListNode Last = fack;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                Last.next = cur1;
                Last = cur1;
                cur1 = cur1.next;
            } else {
                Last.next = cur2;
                Last = cur2;
                cur2 = cur2.next;
            }
        }
        if (cur1 == null) {
            Last.next = cur2;
        } else {
            Last.next = cur1;
        }
        return fack.next;
    }


//分支较多
    private static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        // 定义了两个引用，用来遍历链表
        ListNode cur1 = list1;
        ListNode cur2 = list2;

        // 新链表的头结点和尾结点
        // 空链表，所以都是 null
        ListNode nHead = null;
        ListNode nLast = null;

        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                // 把 cur1 尾插到新链表 开始
                if (nHead == null) {    // 如果新链表为空（只有第一次插入才是空的）
                    nHead = cur1;
                } else {
                    nLast.next = cur1;
                }
                nLast = cur1;   // 更新新链表的尾结点是新插入的结点
                // 把 cur1 尾插到新链表 结束

                cur1 = cur1.next;   // 让 cur1 后移一步
            } else {
                if (nHead == null) {
                    nHead = cur2;
                } else {
                    nLast.next = cur2;
                }
                nLast = cur2;
                cur2 = cur2.next;
            }
        }

        // 有一个链表为空了
        if (cur1 != null) {
            nLast.next = cur1;
        } else {
            nLast.next = cur2;
        }

        return nHead;
    }

    private static void printList(ListNode head) {
        for (ListNode cur = head; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
    }

    public static void main(String[] args){
        ListNode n5=new ListNode(5);
        ListNode n4=new ListNode(4,n5);
        ListNode n3=new ListNode(3,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);
        //12345
        ListNode m3=new ListNode(13);
        ListNode m2=new ListNode(7,m3);
        ListNode m1=new ListNode(0,m2);
        //0 7 13
        ListNode result=mergeTwoLists2(n1,m1);
        printList(result);


    }
}
