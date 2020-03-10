package MySort;

public class practice {
   public static void swap(int[] arr,int x,int y){
       arr[x]=arr[x]+arr[y]-(arr[y]=arr[x]);
   }
   /*
   插入排序
   时间复杂度：最坏情况(1+2+3+...+n-1)~o(n^2)---->逆序序列 最好情况:o(n)---->顺序序列，不进行内层循环
   稳定性：稳定
   空间复杂度：常数空间o(1)
    */
   public static void insertSort1(int[] arr){
       //开始可以认为第0个位置是排好序
       for(int i=0;i<arr.length-1;i++){
           //i:表示已排序数据的最后一个位置
           int end=i;
           //待排序元素位置
           int key=arr[i+1];
           while(end>=0&&arr[end]>key){
               //把大的元素位置向后移动
               arr[end+1]=arr[end];
               //继续向前搜索
               end--;
           }
           //end:-1 或者<=key的一个位置
           arr[end+1]=key;
       }
   }

   public static void insertSort2(int[] arr){
       //开始可以认为第0个位置是排好序
       for(int i=1;i<arr.length;i++){
           //表示已排好数据的最后一个位置
           int end=i-1;
           //i:下一个排序元素的位置
           int key=arr[i];
           while(end>=0&&arr[end]>key){
               arr[end+1]=arr[end];
               --end;
           }
           arr[end+1]=key;
       }
   }

   /*
   希尔排序：改进的插入排序，数据越有序，优化的空间就越小
   时间复杂度：o(n)-o(n^2)--->o(n^1.3)
   稳定性：不稳定
   空间复杂度：常数空间---->o(1)
    */
   public static void shellSort(int[] arr){
       //对数据进行分组
       //每组数据进行插入排序：逻辑分组
       //同一组数据，它们之间的间隔不一定为1
       int gap=arr.length;
       while(gap>1){
           gap=gap/3+1;
           //i:表示已经排序数据的最后一个位置
           for(int i=0;i<arr.length-gap;i++){
               int end=i;
               int key=arr[i+gap];
               while(end>=0&&arr[end]>key){
                   arr[end+gap]=arr[end];
                   end-=gap;
               }
               arr[end+gap]=key;
           }
       }

   }
   /*
   选择排序：每次选一个大的元素，放在固定的位置
   时间复杂度：o(n^2)
   稳定性：可以让它稳定/不稳定
   空间复杂度：常数空间
    */
   public static void selectSort1(int[] arr){
       for(int i=arr.length-1;i>=0;i--){
           int end=i;
           int maxid=i;
           //从未排序的数据中找最大值的索引
           for(int j=end-1;j>=0;j--){
               if(arr[j]>arr[maxid]){
                   maxid=j;
               }
           }
           swap(arr,maxid,end);
       }
   }

   public static void selectSort2(int[] arr){
       //思路：在已有区域选出一个最大的元素和一个最小的元素分别放在begin和end位置，之后再缩小空间
       int begin=0;
       int end=arr.length-1;
       while(begin<end){
           int max=begin;
           int min=begin;
           for(int i=begin;i<=end;i++){
               //维持稳定性
               //最小值选前面（min开始为0)
               if(arr[i]<arr[min]){
                   min=i;
               }
               //最大值选后面(max开始为0)
               if(arr[i]>=arr[max]){
                   max=i;
               }
           }
           swap(arr,begin,min);
           //如果最大值在起始位置，则经过上面的交换，最大值被移动到min指向的位置
           if(max==begin){
               max=min;
           }
           swap(arr,end,min);
           --end;
           ++begin;
       }
   }


   public static void shifDownBig(int[] arr,int parent,int sz){
       int child=2*parent+1;
       while(child<sz){
           //两个孩子节点中选一个最大的
           if(child+1<sz&&arr[child+1]>arr[child]){
               child++;
           }
           if(arr[parent]<arr[child]){
               swap(arr,child,parent);
               parent=child;
               child=parent*2+1;
           }else{
               break;
           }
       }
   }

   /*
   堆排序
   时间复杂度：建堆：o(n) log(n)+log(n-1)+log(n-2)+...+1---->n*log(n)
   稳定性：不稳定---->向下调整可能会破坏相对位置
   空间复杂度：常数空间o(1)
   */
   public static void heapSort(int[] arr){
       int len=arr.length;
       for(int i=(len-2)/2;i>=0;i--){
           shifDownBig(arr,i,len);
       }
       //交换堆顶元素和最后一个元素，长度减一，向下调整，堆排序，重复此过程
       //len:未排序的元素个数
       int end=len-1;
       while(end>0){
           swap(arr,0,end);
           shifDownBig(arr,0,end);
           --end;
       }
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
    非递归
     */




    //合并连个有序区间的数据，使其成为一个有序的区间
    public static void mergeInternal(int[] arr,int left,int mid,int right,int[] tmp){
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
     */
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




}
