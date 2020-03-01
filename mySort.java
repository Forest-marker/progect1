package MySort;

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
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
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
}
