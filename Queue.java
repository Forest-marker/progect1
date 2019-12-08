package Stack;

class Node{
    int value;
    Node next;
}
public class Queue {
    Node front;
    Node rear;
    int size;
    public Queue(){
        front=rear=null;
        size=0;
    }
    public void offer(int value){
        Node node=new Node();
        node.value=value;
        if(front==null){
            front=rear=node;
        }else{
            rear.next=node;
            rear=rear.next;
        }
        size++;
    }
    public int peek(){
        if(front==null){
            return -1;
        }
        return front.value;
    }
    public void poll(){
        if(front==null){
            return;
        }
        front=front.next;
        if(front==null){
            rear=null;
        }
        --size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }

    public static void main(String[] args) {
        Queue q=new Queue();
        System.out.println(q.isEmpty());
        System.out.println(q.size());
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        System.out.println(q.isEmpty());
        System.out.println(q.size());
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.poll();
        }
        System.out.println(q.isEmpty());
        System.out.println(q.size());

    }
}
