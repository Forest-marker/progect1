package Map;

import java.util.HashMap;
import java.util.Map;

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val) {
        val = _val;
        next =null;
        random =null;
    }
}
public class copyRandomList {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        //拷贝节点
        Node cur=head;
        while(cur!=null){
            Node next=cur.next;
            Node copy=new Node(cur.val);
            cur.next=copy;
            copy.next=next;
            cur=next;
        }
        //链接随机指针
        cur=head;
        Node copy=head.next;
        while(cur!=null){
            //复制的节点的随机指针的指向便是前一个指针的随机指针的指向的下一个节点
            copy=cur.next;
            Node next=copy.next;
            if(cur.random!=null){
                copy.random=cur.random.next;
            }else{
                copy.random=null;
            }
            cur=next;
        }
        //拆链
        cur=head;
        Node newH=head.next;
        copy=newH;
        //拆链形成两个链表
        while(cur!=null){
            Node next=copy.next;
            cur.next=next;
            if(next!=null){
                copy.next=next.next;
            }
            cur=next;
            copy=copy.next;
        }
        return newH;
    }

    //法二
    public Node copyRandomList2(Node head){
        if(head==null){
            return null;
        }
        Map<Node,Node> mp=new HashMap<>();
        Node newH,newT;
        newH=newT=null;
        Node cur=head;
        while(cur!=null){
            //复制链表节点形成一条新链表
            Node node=new Node(cur.val);
            if(newH==null){
                newH=newT=node;
            }else{
                newT.next=node;
                newT=newT.next;
            }
            //构建一个映射关系
            //使新创建的链表找随机指针时，能够根据原来链表的随机指针指向，一一对应到新建链表的随机指向
            mp.put(cur,node);
            cur=cur.next;
        }
        //构建随机指针
        cur=head;
        newT=newH;
        while(cur!=null){
            if(cur.random!=null){
                newT.random=mp.get(cur.random);
            }else{
                newT.random=null;
            }
            cur=cur.next;
            newT=newT.next;
        }
        return newH;
    }

}
