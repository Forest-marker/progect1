package MySort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class mySort {
    /*
    插入排序
    时间复杂度：最坏情况1+2+3+4+...=n-1 O(n^2)逆序序列 最好情况(原来都是有序的)O(n)
    稳定性：稳定（相同元素相对位置不会变化）
    空间复杂度：此题中局部变量（12bit)，常数空间O(1)
     */
    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int key = arr[i + 1];
            //i:表示已经排好序的最后一个元素位置
            int end = i;
            while (end >= 0 && arr[end] < key) {
                arr[end + 1] = arr[end];
                --end;
            }
            //注意此处是end+1 因为前面有end--
            //没有进while循环也是原来不变,即end+1位置为key
            arr[end + 1] = key;
        }
    }

    public static void hellSort(int[] arr){
        int gap=arr.length;
        while(gap>1){
            gap=gap/3+1;
            for(int i=0;i<arr.length-gap;i++){
                int end=i;
                int key=arr[end+gap];
                while(end>=0&&arr[end]>key){
                    arr[end+gap]=arr[end];
                    end=end-gap;
                }
                arr[end+gap]=key;
            }
        }
    }

    public static void swap(int[] arr,int x,int y){
        /*int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;*/
        arr[x]=arr[x]+arr[y]-(arr[y]=arr[x]);
    }



    //选择排序
    //思路：选择第一大（小）的元素放在最后一个位置，选择第二大的元素放在倒数第二个位置，选择第三大的元素放在倒数第三的位置
    //依此类推
    public static void selectSort(int[] arr){
        //i:未排序的最大位置
        for(int i=arr.length-1;i>0;i--){
            //每次选择一个最大的压入一个位置
            int end=i;
            int maxID=i;
            //从所以未排序的数据中找最大的索引
            for(int j=end-1;j>=0;j--){
                if(arr[j]>arr[maxID]){
                    maxID=j;
                }
            }
            swap(arr,maxID,end);
        }
    }

    public static int partition1(int[] arr,int left,int right){
        //基准值
        int key=arr[left];
        //开始下标（基准下标）
        int start=left;
        while(left<right){
            //从后向前找第一额给小于key的数据位置
            //先从右边找，再从左边找，反之会出错（不满足左边都大，右边都小）
            while(left<right&&arr[right]>=key){
                --right;
            }
            //从前向后找第一个大于key的数据位置
            while(left<right&&arr[left]<=key){
                ++left;
            }
            swap(arr,left,right);
        }
        //把基准值和相遇位置值交换
        //错误：arr[left]=key,相遇值被覆盖
        swap(arr,start,left);
        return left;
    }

    public static void quickSort(int[] arr,int left,int right){
        if(left<right){
            int mid=partition1(arr,left,right);
            quickSort(arr,left,mid-1);
            quickSort(arr,mid+1,right);
        }

    }

    public static void improveSelectSort(int[] arr){
        int begin=0;
        int end=arr.length-1;
        while(begin<end){
            int minidx=begin;
            int maxidx=begin;
            for(int i=begin;i<=end;++i) {
                //最小值选前面的
                if (arr[i] < arr[minidx]) {
                    minidx = i;
                }
                //注意等号，最大值选后面的
                if (arr[i] >= arr[maxidx]) {
                    maxidx = i;
                }
            }
                swap(arr,begin,maxidx);
                if(maxidx==begin){
                    maxidx=minidx;
                }
                swap(arr,end,maxidx);
                ++begin;
                --end;

        }
    }

    //希尔排序，堆排序
    public static void shiftDownBig(int[] arr,int parent,int size){
        int left=parent*2+1;
        while(left<size){
            if(left+1<size&&arr[left+1]>arr[left]){
                left++;
            }
            if(arr[left]>arr[parent]){
                swap(arr,left,parent);
                parent=left;
                left=parent*2+1;
            }else{
                break;
            }
        }
    }

    public static void shiftDownSmall(int[] arr,int parent,int size){
        int left=parent*2+1;
        while(left<size){
            if(left+1<size&&arr[left+1]<arr[left]){
                left++;
            }
            if(arr[left]<arr[parent]){
                swap(arr,left,parent);
                parent=left;
                left=parent*2+1;
            }else{
                break;
            }
        }
    }
    //不稳定
    public static void heapSortBig(int[] arr){
        int len=arr.length;
        for(int i=(len-2)/2;i>=0;--i){
            shiftDownBig(arr,i,len);
        }
        int end=len-1;
        while(end>0){
            //只剩一个元素不用调整
            swap(arr,0,end);
            //元素个数改变
            shiftDownBig(arr,0,end);
            --end;
        }
    }
    //降序
    public static void heapSortSmall(int[] arr){
        int len=arr.length;
        for(int i=(len-2)/2;i>=0;--i){
            shiftDownSmall(arr,i,len);
        }
        int end=len-1;
        while(end>0){
            //只剩一个元素不用调整
            swap(arr,0,end);
            //元素个数改变
            shiftDownSmall(arr,0,end);
            --end;
        }
    }

    //时间复杂度o(n)-o(n^2) 最好：顺序+标记o(n) 最坏：逆序
    //稳定性：稳定
    //空间复杂度o(1)
    public static void bubbleSort(int[] arr){
        //len:未排序的元素个数
        int len=arr.length;
        while(len>0){
            //flag->true 已经有序
            boolean flag=true;
            //一轮冒泡排序，排好一个元素位置
            for(int i=0;i<len-1;i++){
                if(arr[i]>arr[i+1]){
                    swap(arr,i,i+1);
                    flag=false;
                }
            }
            if(flag){
                //整个数据是有序
                break;
            }
            --len;
        }
        }


    public static void main(String[] args) {
        List<Integer> list=new LinkedList<>();
        int[] a={10,1,11,3,4,7,5,2,1};
        int[] b=a.clone();
        heapSortBig(a);
        System.out.println(Arrays.toString(a));
        heapSortSmall(b);
        System.out.println(Arrays.toString(b));
    }
}
