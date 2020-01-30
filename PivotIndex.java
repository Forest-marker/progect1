package gittub;
//寻找数组的中心索引

//给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。

//我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。

//如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。

public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int sum1=0;
        int sum2=0;
        for(int i=0;i<nums.length;i++){
            sum1=0;
            sum2=0;
            for(int j=i-1;j>=0;j--){
                sum1+=nums[j];
            }
            for(int k=i+1;k<nums.length;k++){
                sum2+=nums[k];
            }
            if(sum1==sum2){
                return i;
            }
        }
        return -1;
    }

    //中心索引，前缀法
    //利用数组的总和sum和中心索引i左边所有元素的和leftsum呈现一个关系
    //sum=leftsum+leftsum+nums[i]
     /* public int pivotIndex(int[] nums) {
          int sum=0;
          int leftsum=0;
          for(int a:nums){
              //求数组的总和
              sum+=a;
          }
          for(int i=0;i<nums.length;i++){
              //满足sum=leftsum+leftsum+nums[i]关系的中心索引
              if(sum==2*leftsum+nums[i]){
                  return i;
              }
              leftsum+=nums[i];
          }
          return -1;
      }*/
}
