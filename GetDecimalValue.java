package gittub;

 //二进制链表转整数
//给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
//请你返回该链表所表示数字的 十进制值 。
public class GetDecimalValue {
   /* public int getDecimalValue(ListNode head) {
        Stack<Integer> stack=new Stack<>();
        ListNode cur=head;
        //取出所有结点的值存入栈中
        while(cur!=null){
            stack.push(cur.val);
            cur=cur.next;
        }
        int len=stack.size();
        int sum=0;
        int i=0;
        while(i<len){
            //二进制转十进制
            sum+=stack.pop()*Math.pow(2,i);
            i++;
        }
        return (int)sum;
    }*/

   //法二
        public int getDecimalValue(ListNode head) {
            int sum=0;
            ListNode cur=head;
            while(cur!=null){
                sum=(sum<<1)+cur.val;
                cur=cur.next;
            }
            return sum;
        }
    }

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }