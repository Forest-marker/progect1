package Offer;
 //旋转数组
//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
public class Rotate {
    //双层for循环，头插法
    //时间复杂度O(nk)
    //空间复杂度O(1)
   /* public void rotate(int[] nums, int k) {
        int len=nums.length;
        int temp=0;
        for(int i=0;i<k;i++){
            temp=nums[len-1];
            for(int j=len-1;j>0;j--){
               nums[j]=nums[j-1];
            }
            nums[0]=temp;
        }
    }*/
    //选择数组翻转
    //时间复杂度O(n) 空间复杂度O(1)
    //例如12345 （3）
    //总共进行3次翻转
    //第一次整体翻转 54321
    //第二次0-2翻转 34521
    //第三次3-length-1 3-4翻转 34512
    //需要特殊考虑数组越界，当翻右移次数K大于数组元素个数的情况 k=k%数组的长度
    //以及没有元素，以及只有一个元素的情况都属于特殊情况，不做处理
    public void rotate(int[] nums,int k){
        if(nums.length<2){
            return;
        }
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int[] nums,int begin,int end){
        int temp;
        while(begin<end){
            temp=nums[begin];
            nums[begin]=nums[end];
            nums[end]=temp;
            begin++;
            end--;
        }
    }
}

