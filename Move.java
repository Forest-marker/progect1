package Heap;

import java.util.Arrays;

public class Move {
    //左右子树必须是一个
    //大堆：根结点大于子树根结点的值 小堆：根结点雄安与子树根结点的值
    //向下调整，左右子树必须是一个堆，才能调整
    //转换为小堆
    public void shifdown(int[] array,int size,int index){
        int left=index*2+1;//左孩子
        while(left<size){
            int min=left;
            int right=index*2+2;
            if(right<size){
                if(array[left]>array[right]){
                    min=right;
                }
            }
            if(array[index]<=array[min]){
                break;
            }
            int t=array[index];
            array[index]=array[min];
            array[min]=t;
            index=min;
            left=index*2+1;
        }
    }

    //转换为大堆
    public void Big_shiftdown(int[] array,int size,int index){
        int left=index*2+1;
        while(left<size){
            int max=left;
            int right=index*2+2;
            if(right<size){
                if(array[right]>array[left]){
                     max=right;
                }
            }
            if(array[index]>array[max]){
                break;
            }
            int t=array[index];
            array[index]=array[max];
            array[max]=t;
            index=right;
            left=index-1;
        }
    }


    public void createHeap(int size,int[] array){
        for(int i=(size-1)/2;i>=0;i--){
            AdjustDown(array,size,i);
        }
    }


    //建大堆
    public void AdjustDown(int arr[], int size, int root){
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        int max;
        //没有左孩子
        if (left >= size){
            return;
        }
        //右孩子存在且大于左孩子
        if (right < size && arr[right] > arr[left]){
            max = right;
        }
        else{
            max = left;
        }
        if (arr[root] >= arr[max]){
            return;
        }
        int t=arr[root];
        arr[root]=arr[max];
        arr[max]=t;
        AdjustDown(arr, size, max);
    }




    public static void main(String[] args) {
        int[] array = { 1,5,3,8,7,6 };
        Move p=new Move();
        p.createHeap(6,array);
        System.out.println(Arrays.toString(array));

    }
}
