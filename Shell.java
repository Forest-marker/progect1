package Sorted;

import java.util.Arrays;

public class Shell {
    //希尔排序
    public static void shellSort(int[] array){
        int gap=array.length/2;
        while(gap>1){
            shellGap(array,gap);
            gap=gap/2;
        }
        shellGap(array,1);
    }

    public static void shellGap(int[] array,int gap){
        //直接插入排序改编
        for(int i=1;i<array.length;i++){
            int v=array[i];
            int j=i-gap;
            for(;j>=0&&array[j]>v;j-=gap){
                array[j+gap]=array[j];
            }
            array[j+gap]=v;
        }
    }

    public static void main(String[] args) {
        int[] array={1,4,3,2,6,5,3};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }
}
