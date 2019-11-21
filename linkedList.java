public class linkedList{
	int val;
	linkedList next;
	linkedList(int val,linkedList next){
		this.val=val;
		this.next=next;
	}
	linkedList(int val){
		this(val,null);
	}
	@Override
	public String toString(){
		return String.format("linkedList{%d}",val);
	}
	//自己手动创建一个链表
	public static linkedList buildlinkedList( ){
		linkedList p1=new linkedList(1);
		linkedList p2=new linkedList(2);
		linkedList p3=new linkedList(3);
		p1.next=p2;
		p2.next=p3;
		return p1;
	}
	//打印输出链表
	public static void printlinkedList(linkedList head){
		linkedList cur=head;
		while(cur!=null){
			System.out.println(cur.val);
			cur=cur.next;
		}
	}
	//头插 head=null O(1)
	public static linkedList pushFront(linkedList head,int val){
		linkedList p1=new linkedList(val);
		p1.next=head;
		return p1;
	}
	//头删
	public static linkedList popFront(linkedList head){
		if(head==null){
			throw new RuntimeException("空链表");
		}
		return head.next;
		
	}
	//尾插
	public static linkedList pushBack(linkedList head,int val){
		linkedList p1=new linkedList(val);
		linkedList cur=head;
		if(cur==null){
			return p1;
		}
		/*while(cur!=null){
			cur=cur.next;
			//Exception in thread "main" java.lang.NullPointerException
		}*/
		//此处一定要注意是cur.next!=null,而不是cur!=null否则会有空指针异常
		//因为当跳出循环,cur为null,则下面的cur.next会抛出异常,因为不能对null进行解引用
		if(cur.next!=null){
			cur=cur.next;
		}
		cur.next=p1;
		return head;
		
	}
	//尾删
	public static linkedList popBack(linkedList head){
		if(head==null){
			throw new RuntimeException("链表为空");
		}
		if(head.next==null){
			return null;
		}
		linkedList cur=head;
		while(cur.next.next!=null){
			cur=cur.next;
		}
		cur.next=null;
		return head;
	}
	//主函数调用
	public static void main(String[] args){
		//linkedList head=buildlinkedList();
		linkedList head=null;
		//head=pushFront(head,11);
		//head=pushFront(head,12);
	    //head=pushFront(head,13);
		printlinkedList(head);
		//head=popFront(head);
		//printlinkedList(head);
		//head=pushBack(head,10);
		head=popBack(head);
		printlinkedList(head);
		
	}
	
}