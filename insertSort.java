package Sorted;

import java.util.Arrays;

public class insertSort {
    //直接插入排序
    //插入排序，初始数据越接近有序，时间效率越高。
    //每次选择无序区间的第一个元素，在有序区间内选择合适的位置插入
    public static void InsertSort(int[] array){
        //刚开始留一个元素当作有序区间
        for(int i=1;i<array.length;i++){
            int j=i-1;
            int v=array[i];
            //因为刚开始有一个是有序，再排序一次，就是两个有序，因此再之后循环，不满足升序就依次往后赋值，然后把最小的赋值给前面最后不成立元素
            //1324
            //1334
            //1234
            for(;j>=0&&array[j]>array[j+1];j--){
                array[j+1]=array[j];
            }
            //不成立是跳出循环，因此交换时应该是j+1
            array[j+1]=v;
        }
    }

    public static void main(String[] args) {
        int[] a={3,1,2,4,5};
        InsertSort(a);
        System.out.println(Arrays.toString(a));
    }
}
