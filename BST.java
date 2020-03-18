package Map;
class Person{
    private String name;
    private String id;
}
//泛型对应二叉搜索树 模拟Map
public class BST<K extends Comparable<K>,V> {
    private static class MyEntry<K ,V>{
        K key;
        V value;
        MyEntry<K,V> left;
        MyEntry<K,V> right;
        public MyEntry(K key,V value){
            this.key=key;
            this.value=value;
        }
    }
    private MyEntry<K,V> root=null;
    private int size=0;

    public V put(K key,V value){
        if(root==null){
            root=new MyEntry<>(key,value);
            ++size;
            return null;
        }
        MyEntry<K,V> cur=root;
        MyEntry<K,V> parent=null;
        while(cur!=null){
            parent=cur;
            //
            int r=cur.key.compareTo(key);
            if(r==0){
                //key存在，修改key的value值，返回旧的value
                V old=cur.value;
                cur.value=value;
                return old;
            }else if(r>0){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        cur=new MyEntry<>(key,value);
        int r=parent.key.compareTo(key);
        if(r>0){
            parent.left=cur;
        }else{
            parent.right=cur;
        }
        ++size;
        return null;
    }

    public void inOrder(){
        inOrderInternal(root);
        System.out.println();
    }

    private void inOrderInternal(MyEntry<K,V> root){
        if(root!=null){
            inOrderInternal(root.left);
            System.out.println(root.key+"--->"+root.value);
            inOrderInternal(root.right);
        }
    }

    public V remove(K key){
        if(root==null){
            return null;
        }
        MyEntry<K,V> cur=root;
        MyEntry<K,V> parent=null;
        while(cur!=null){
           int r=cur.key.compareTo(key);
           if(r==0){
               break;
           }else if(r>0){
               parent=cur;
               cur=cur.left;
           }else{
               parent=cur;
               cur=cur.right;
           }
        }
        if(cur==null){
            return null;
        }
        V old=cur.value;
        remove(parent,cur);
        return old;
    }

    public void remove(MyEntry<K,V> parent,MyEntry<K,V> cur){
        if(cur.left==null){
            if(cur!=root){
                if(parent.left==cur){
                    parent.left=cur.right;
                }else{
                    parent.right=cur.right;
                }
            }else{
                root=cur.right;
            }
        }else if(cur.right==null){
            if(cur!=root){
                if(parent.left==cur){
                    parent.left=cur.left;
                }else{
                    parent.right=cur.left;
                }
            }else{
                //要删除节点为根节点
                root=cur.left;
            }
        }else{
            //左右孩子节点都存在，找左子树的最节点或者右子树的最左节点，进行交换，删除最左或最右节点
            //右子树的最左节点
            /*parent=cur;
            MyEntry<K,V> next=cur.right;
            while(next.left!=null){
                parent=next;
                next=next.left;
            }
            //交换
            cur.key=next.key;
            cur.value=next.value;
            if(parent.left==next){
                parent.left=next.right;
            }else{
                parent.right=next.right;
            }*/
            //左子树的最右节点
            parent=cur;
            MyEntry<K,V> next=cur.left;
            while(next.right!=null){
                parent=next;
                next=next.right;
            }
            //交换
            cur.key=next.key;
            cur.value=next.value;
            if(parent.left==next){
                parent.left=next.left;
            }else{
                parent.right=next.left;
            }
    }
    }

    public V get(K key){
        if(root==null){
            return null;
        }
        MyEntry<K,V> cur=root;
        while(cur!=null){
            int r=cur.key.compareTo(key);
            if(r==0){
                return cur.value;
            }else if(r>0){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        return null;
    }

    public static void test1(){
        BST<String,String> bst=new BST();
        String ret=bst.put("周老师","11111");
        System.out.println(ret);
        ret = bst.put("周老师", "000000000");
        System.out.println(ret);
        ret = bst.put("陈老师", "11111");
        System.out.println(ret);
        ret = bst.put("徐老师", "222222222");
        System.out.println(ret);
        ret = bst.put("陈老师", "333");
        System.out.println(ret);
    }

    public static void test2(){
        //Person没有实现Comarable接口，所以不能作为二叉搜索树的key
        //BST<Person,String> bst=new BST<Person,String>();
        BST<Integer,Integer> bst=new BST<>();

        bst.put(4,1);
        bst.put(5, 1);
        bst.put(6, 1);
        bst.put(1, 1);
        bst.put(2, 1);
        bst.put(3, 1);
        bst.inOrder();

    }

    public static void test3(){
        BST<Integer, Integer>  bst = new BST<>();
        bst.put(7, 7);
        bst.put(8, 8);
        bst.put(3, 3);
        bst.put(4, 4);
        bst.put(1, 1);
        bst.put(2, 2);
        bst.put(5, 5);
        bst.put(6, 6);
        bst.inOrder();
        Integer ret = bst.remove(10);
        System.out.println(ret);
        bst.inOrder();
        ret = bst.remove(5);
        System.out.println(ret);
        bst.inOrder();
        ret = bst.remove(5);
        System.out.println(ret);
        bst.inOrder();
        ret = bst.remove(7);
        System.out.println(ret);
        bst.inOrder();


    }

    public static void test4(){
        BST<Integer,Integer> bst=new BST<>();
        bst.put(7, 7);
        bst.put(8, 8);
        bst.put(3, 3);
        bst.put(4, 4);
        bst.put(1, 1);
        bst.put(2, 2);
        bst.put(5, 5);
        bst.put(6, 6);
        //int ret=bst.get(10);
        //显示空指针异常
        Integer ret=bst.get(10);
        System.out.println(ret);
        ret=bst.get(5);
        System.out.println(ret);
        ret=bst.get(6);
        System.out.println(ret);

    }
    public static void main(String[] args) {
        //test1();
        //test2();
        test3();
        //test4();
    }
}
