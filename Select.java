package Sorted;

//选择排序
//每一次从无序区间选出最大（或最小）的一个元素，存放在无序区间的最后（或最前），直到全部待排序的数据元
//素排完 。
public class Select {

    public static void selectSort(int[] array){
        //外部循环（比较次数），只剩一个元素时不需要比较，所以少一次
        for(int i=0;i<array.length-1;i++){
            //思路：每次设第一个元素为最大元素
            //然后再与后面元素依次比较，只要有大的就重新设下标，直至找到最大把值赋值给最后面元素
            int max=0;
            for(int j=1;j<array.length-i;j++){
                if(array[j]>array[max]){
                    max=j;
                }
            }
            //交换前后元素，保证最后面是最大的元素
            int t=array[max];
            array[max]=array[array.length-i-1];
            array[array.length-i-1]=t;
        }
    }
}
