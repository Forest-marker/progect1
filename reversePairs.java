package DayOverDay_parctice;

//力扣：面试题51. 数组中的逆序对
//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
public class reversePairs {
    //思路：与归并排序很相像（求逆序对）
    //不同的是 因为求的是前面的元素大于后面的元素，因此每次要从每个分组的最后开始进行相应的元素比较，（前面的元素大于后面分组的元素，则说明逆序对有后面分组当前元素所在为止到最左边元素的长度），因为已经是有序的两个分组，前面的元素大于后面的，则也大于后面元素之前的元素
    //反之，若找的是（正序对）前面的元素小于后面的元素，从每个分组的最开始元素进行比较，若小于后面则找到的正序对数是（包含此元素到此分组最后所含有的元素），同样因为是有序，前面比后面最小元素小，则也比后面元素小
    public int count=0;
    public int reversePairs(int[] nums) {
        if(nums.length<2){
            return 0;
        }
        int[] tmp=new int[nums.length];
        mergeSort(nums,0,nums.length-1,tmp);
        return count;
    }
    public void mergeSort(int[] arr,int left,int right,int[] tmp){
        if(left>=right){
            return;
        }
        int mid=(left+right)/2;
        mergeSort(arr,left,mid,tmp);
        mergeSort(arr,mid+1,right,tmp);
        mergeInternal(arr,left,mid,right,tmp);
    }

    public void mergeInternal(int[] arr,int left,int mid,int right,int[] tmp){
        int begin1=left,end1=mid;
        int begin2=mid+1,end2=right;
        int idx=right;
        while(begin1<=end1&&begin2<=end2){
            if(arr[end1]>arr[end2]){
                tmp[idx--]=arr[end1--];
                count+=(end2-mid);
            }else{
                tmp[idx--]=arr[end2--];
            }
        }
        while(begin1<=end1){
            tmp[idx--]=arr[end1--];
        }
        while(begin2<=end2){
            tmp[idx--]=arr[end2--];
        }
        for(int i=left;i<=right;i++){
            arr[i]=tmp[i];
        }
    }
}
