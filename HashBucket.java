package Map;

//哈希表
public class HashBucket {
    //哈希表结构 key value next
    private static class Node{
        int key;
        int value;
        Node next=null;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
            next=null;
        }
    }
    private Node[] array;
    private int size;
    //上限因子
    private static final double LoAD_FACTORY=0.7;

    //链表结构
    public HashBucket(){
        array=new Node[10];
        size=0;
    }

    //负载因子
    public double loadFactory(){
        //元素个数/数组长度
        return size*1.0/array.length;
    }

    public int put(int key,int value){
        //检查容量
        if(loadFactory()>=LoAD_FACTORY){
            //增容
            resize();
        }
        //插入
        //1.计算哈希值
        int idx=key%array.length;
        //2.不能插入重复的key,首先要查看key是否已经存在，遍历当前的链表
        Node cur=array[idx];
        while(cur!=null){
            //相同的元素(key已经存在)
            if(cur.key==key){
                int old=cur.value;
                cur.value=value;
                return old;
            }
            cur=cur.next;
        }
        //3.插入:单链表的头插
        cur=new Node(key,value);
        cur.next=array[idx];
        array[idx]=cur;

        ++size;
        return -1;
    }

    public void resize(){

    }
}
