package MySort;

import java.util.Stack;

public class quickOrmergeSort {
    public static void swap(int[] arr,int x,int y){
        arr[x]=arr[x]+arr[y]-(arr[y]=arr[x]);
    }
    public static int partition1(int[] arr,int left,int right){
        //基准位置下标
        int start=left;
        //基准值
        int key=arr[left];
        while(left<right){
            //一定要先从后向前找第一个小于key的位置，否则数据的位置，否则数据的位置会产生错误
            while(left<right&&arr[right]>=key){
                //从后向前找第一个小于key元素的位置
                --right;
            }
            while(left<right&&arr[left]<=key){
                //从前向后找第一个大于key的位置
                ++left;
            }
            swap(arr,left,right);
        }
        //将left==right的位置与刚开始的基准值位置交换
        swap(arr,left,start);
        return left;
    }

    public static int partition2(int[] arr,int left,int right){
        //获取基准值
        int key=arr[left];
        while(left<right){
            //从右边找第一个大于key的数据，填左边的坑
            while(left<right&&arr[right]>=key){
                --right;
            }
            //挖坑
            arr[left]=arr[right];
            //从左边找第一个大于key的数据，填右边的坑
            while(left<right&&arr[left]<=key){
                ++left;
            }
            //填坑
            arr[right]=arr[left];
        }
        //填基准值到中间相遇的地方
        arr[left]=key;
        return left;
    }
    //三数取中法，为了让数据分组更加均匀
    public static int getMid(int[] arr,int left,int right){
        //从arr[left],arr[mid,arr[left]中选一个中间值
        int mid=(left+right)/2;
        if(arr[mid]>arr[left]){
            if(arr[mid]<arr[right]){
                return mid;
            }else{
                //min>left,>=right
                if(arr[left]>arr[right]){
                    return left;
                }else{
                    return right;
                }
            }
        }else{
            //mid<==left
            if(arr[mid]>arr[right]){
                return mid;
            }else{
                //mid<=left,<=right
                if(arr[left]<arr[right]){
                    return left;
                }else{
                    return right;
                }
            }
        }
    }

    public static int partition3(int[] arr,int left,int right){
        //三柱取中
        int mid=getMid(arr,left,right);
        swap(arr,left,mid);
        int key=arr[left];
        int prev=left;//最后一个小于key的位置
        int cur=left+1;//下一个小于key的位置
        while(cur<=right){
            //入股cur找到下一个小于key的位置，并且prev和cur之间有大于key的值，则交换prev,cur的值
            if(arr[cur]<key&&++prev!=cur){
                swap(arr,prev,cur);
            }
            ++cur;
        }
        swap(arr,left,prev);
        return prev;
    }
    /*
    快排递归
    时间复杂度：o(nlogn) 最坏时间复杂度:没有优化之前o(n^2)
    稳定性：不稳定 基准值的位置交换时有可能改变相同元素的位置
    空间复杂度：logn
     */
    public static void quickSort(int[] arr,int left,int right){
        if(left<right){
            int mid=partition1(arr,left,right);
            quickSort(arr,left,mid-1);
            quickSort(arr,mid+1,right);
        }
    }
    /*
    非递归：模拟递归的过程
    1.选基准值
    2.根据基准值分组
    3.给划分的小组进行重复1，2的过程
     */
    public static void quickSortNoR(int[] arr){
        int left=0;
        int right=arr.length-1;
        //
        Stack<Integer> stack=new Stack<Integer>();
        if(left<right){
            stack.push(left);
            stack.push(right);
        }
        while(!stack.isEmpty()){
            //取出栈顶的一对区间值
            int right1=stack.pop();
            int left1=stack.pop();
            //分组
            int mid=partition3(arr,left1,right1);
            //显得分组继续压栈
            if(mid-1>left){
                stack.push(left);
                stack.push(mid-1);
            }
            if(mid+1<right){
                stack.push(mid+1);
                stack.push(right1);
            }
        }

    }




    //合并连个有序区间的数据，使其成为一个有序的区间
    /*public static void mergeInternal(int[] arr,int left,int mid,int right,int[] tmp){
        int begin1=left,end1=mid;
        int begin2=mid+1,end2=right;
        int idx=left;
        while(begin1<=end1&&begin2<=end2){
            //<:不稳定
            //<=稳定
            if(arr[begin1]<=arr[begin2]){
                tmp[idx++]=arr[begin1++];
            }else{
                tmp[idx++]=arr[begin2++];
            }

        }
        //判断是否还有元素
        while(begin1<=end1){
            tmp[idx++]=arr[begin1++];
        }
        while(begin2<=end2){
            arr[idx++]=arr[begin2++];
        }
        for(int i=left;i<=right;i++){
            arr[i]=tmp[i];
        }
    }

    /*
    归并递归
    时间复杂度：o(nlogn)
    稳定性：稳定
    空间复杂度：o(n) 需要辅助空间队元素进行归并，不能原地归并

    public static void mergeSort(int[] arr,int left,int right,int[] tmp){
        if(left>=right){
            return;
        }
        //分组：分解
        int mid=(left+right)/2;
        //首先给[left,mid]和[mid+1,right]小组据进行排序
        mergeSort(arr,left,mid,tmp);

        mergeSort(arr,mid+1,right,tmp);
        //归并：前提条件--->小组数据已经有序
        mergeInternal(arr,left,mid,right,tmp);
    }

    public static void merge(int[] arr){
        int[] tmp=new int[arr.length];
        mergeSort(arr,0,arr.length-1,tmp);
    }


    public static void mergeNoR(int[] arr){
        //例如6个元素 [0 1] [2 4] [5 ]
        //7个元素 [0 1] [2 4] [5 6]
        int[] tmp=new int[arr.length];
        //i:每次归并的元素个数
        for(int i=1;i<arr.length;i*=2){
            //j:下一次归并的起始位置
            for(int j=0;j<arr.length;j+=2*i){
                //mergeInternal(arr,j,j+i-1,j+2*i-1,tmp);区间可能越界
                int left=j;
                int mid=j+i-1;
                //右半部分没有数据，不能进行归并
                if(mid>=arr.length-1){
                    continue;
                }
                int right=j+2*i-1;
                //判断右边的区间是否越界
                if(right>=arr.length){
                    right=arr.length-1;
                }
                mergeInternal(arr,left,mid,right,tmp);
            }
        }
    }*/

    public static void mergeInternal(int[] arr, int left, int mid, int right, int[] tmp){
        int begin1 = left, end1 = mid;
        int begin2 = mid + 1, end2 = right;
        int idx = left;
        while(begin1 <= end1 && begin2 <= end2){
            // < : 不稳定
            // <=: 稳定
            if(arr[begin1] <= arr[begin2]){
                //能否原地合并
                tmp[idx++] = arr[begin1++];
            }
            else{
                tmp[idx++] = arr[begin2++];
            }
        }
        //判断是否还有剩余元素
        while(begin1 <= end1)
            tmp[idx++] = arr[begin1++];
        while(begin2 <= end2)
            tmp[idx++] = arr[begin2++];
        //拷贝
        for(int i = left; i <= right; ++i)
            arr[i] = tmp[i];
    }

    /*
        归并递归：
        时间复杂度：O(nlogn)
        稳定性：稳定
        空间复杂度：O(n)  需要辅助空间对元素进行归并，不能原地归并
     */
    public static void mergeSort(int[] arr, int left, int right, int[] tmp){
        if(left >= right)
            return;
        // 分组 /分解
        int mid = (left + right) / 2;
        // 首先给 [left, mid]   和  [mid + 1, right]小组数据进行排序
        mergeSort(arr, left, mid, tmp);
        mergeSort(arr, mid +1, right, tmp);
        //归并： 前提条件----> 小组数据已经有序
        mergeInternal(arr, left, mid, right, tmp);
    }

    public static void merge(int[] arr){
        int[] tmp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, tmp);
    }

    public static void mergeNoR(int[] arr){
        int[] tmp = new int[arr.length];
        //i: 每次归并的元素个数
        for(int i = 1; i < arr.length; i *= 2){
            // j: 下一次归并的起始位置
            for(int j = 0; j < arr.length; j += 2 * i) {
                //mergeInternal(arr, j, j + i - 1, j + 2 * i - 1, tmp);  区间可能越界
                int left = j;
                int mid = j + i - 1;
                //右半部分没有数据，不用进行归并
                if(mid >= arr.length - 1)
                    continue;
                int right = j + 2 * i - 1;
                //判断右边的区间是否越界
                if(right >= arr.length){
                    right = arr.length - 1;
                }
                mergeInternal(arr, left, mid, right, tmp);
            }
        }
    }
}
