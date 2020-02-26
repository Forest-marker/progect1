package twoHundreds;


  class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
  }
public class addTwoNumbers {
    public ListNode addtwoNumbers(ListNode l1, ListNode l2) {
        ListNode fack=new ListNode(0);
        ListNode prev=fack;
        int t=0;
        //t!=0这个条件必须加上
        //例如5+5=10 10/10=1 此时t=1要进位 不然就是0
        //但是0的话不需要进位，因为没有已0开头的数（除过0）
        while(l1!=null||l2!=null||t!=0){
            if(l1!=null){
                t+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                t+=l2.val;
                l2=l2.next;
            }
            //判断此位的数是什么t%10
            prev.next=new ListNode(t%10);
            prev=prev.next;
            //判断进位
            //若有进位，则继续判断，执行相加（例如相加为10则进1）
            t=t/10;
        }
        return fack.next;
    }
}
