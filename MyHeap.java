package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MyHeap {
    //堆存储在数组中，完全二叉树，连续存储空间
    //若根节点大于其子树的值，称为大堆反之称为小堆
    //孩子节点的下标x,则双亲为(x-1)/2
    //双亲结点下标为partent 则左孩子结点为(parent*2)+1 有孩子结点为(parent*2)+2
    public static void swap(int[] arr,int x,int y){
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }

    //向下调整（前提：左右子树必须是一个堆，才能向下调整
    public static void shifDownSmall(int[] array,int size,int parent){
        //此结点与其孩子结点进行比较，若孩子结点比父节点小，则交换，否则不变
        //交换节点后下标相应改变，被交换结点的下标继续作为父节点，与其双亲做比较
        int left=(parent*2)+1;
        while(left<size){
            //两个孩子结点中选一个最大的
            if(left+1<size&&array[left+1]<array[left]){
                left++;
            }
            if(array[left]<array[parent]){
                swap(array,left,parent);
                //更新，继续向下调整
                parent=left;
                left=(parent*2)+1;
            }else{
                break;
            }
        }
    }

    //大堆
    public static void  shiftDownBig(int[] array,int size,int parent){
        int left=(parent*2)+1;
        while(left<size){
            //两个孩子结点中选一个最大的
            if(left+1<size&&array[left+1]>array[left]){
                left++;
            }
            if(array[left]>array[parent]){
                swap(array,left,parent);
                parent=left;
                left=(parent*2)+1;
            }else{
                break;
            }
        }
    }

    //创建堆
    //此时堆的左右子树既不是大堆也不是小堆，若还是从根结点开始调整，则无法确定调整次数，以及具体算法
    //因此要从最小子树开始调整，使局部调整为子树，然后再在局部的基础上才能对上面的结点实现向下调整
    //小堆
    public static void createSmallHeap(int[] array){
        for(int i=(array.length-2)/2;i>=0;i--){
            shifDownSmall(array,array.length,i);
        }
    }

    //大堆
    public static void createBigHeap(int[] array){
        for(int i=(array.length-2)/2;i>=0;i--){
            shiftDownBig(array,array.length,i);
        }
    }

    //向上调整，例如在原有的堆中加入一个元素（实现优先级队列）可模仿入队过程
    //只需要和根节点比较
    //然后更新节点按位置
    public static void shitUpSmall(int[] array,int size,int child){
        int parent=(child-1)/2;
        while(child>0){
            if(array[child]<array[parent]){
                swap(array,child,parent);
                child=parent;
                parent=(child-1)/2;
            }else{
                break;
            }
        }
    }

    //大堆
    public static void shifUpBig(int[] array,int size,int child){
        int parent=(child-1)/2;
        while(child>0){
            if(array[child]>array[parent]){
                swap(array,child,parent);
                child=parent;
                parent=(child-1)/2;
            }else{
                break;
            }
        }
    }

    public static void shifUpSmall(int[] array,int size,int child){
        int parent=(child-1)/2;
        while(child>0){
            if(array[child]<array[parent]){
                swap(array,child,parent);
                child=parent;
                parent=(child-1)/2;
            }else{
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 2, 10, 15, 3, 1, 7, 23, 89};
        int[] copy = arr.clone();
        System.out.println(Arrays.toString(arr));
        MyHeap p = new MyHeap();
        p.createBigHeap(arr);
        System.out.println(Arrays.toString(arr));
        createSmallHeap(copy);
        System.out.println(Arrays.toString(copy));
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.add(9);
        pq.add(2);
        pq.add(10);
        pq.add(15);
        pq.add(3);
        pq.add(1);
        pq.add(7);
        pq.add(23);
        pq.add(89);
        while(!pq.isEmpty()){
            System.out.print(pq.poll()+" ");
        }
    }

}
