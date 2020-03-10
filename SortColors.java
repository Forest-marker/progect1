package MySort;

//题目：75. 颜色分类
//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
//此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class SortColors {
    public void sortColors(int[] nums) {
        //0：红色 1：白色 2：蓝色 排序要求：按照红色、白色、蓝色顺序来排序；相同颜色的元素相邻
        //法一：计数法
        /*
        时间复杂度:o(n)
        空间复杂度:o(1)
        */
        /*int red=0,white=0,blue=0,i;
        for(i=0;i<nums.length;i++){
            if(nums[i]==0){
                red++;
            }else if(nums[i]==1){
                white++;
            }else{
                blue++;
            }
        }
        for( i=0;i<red;i++){
            nums[i]=0;
        }
        for(i=red;i<red+white;i++){
            nums[i]=1;
        }
        for(i=red+white;i<nums.length;i++){
            nums[i]=2;
        }*/
        // 对于所有 idx < i : nums[idx < i] = 0
        // j是当前考虑元素的下标
        int p0 = 0, curr = 0;
        // 对于所有 idx > k : nums[idx > k] = 2
        int p2 = nums.length - 1;
        //1 0 2 0 1 2
        //0 1
    /*
    时间复杂度:o(n)
    空间复杂度:o(1)
    */
        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                // 交换第 p0个和第curr个元素
                // i++，j++
                //此处有两种情况，0和0交换，0和1交换
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            }
            else if (nums[curr] == 2) {
                // 交换第k个和第curr个元素
                // p2--
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            }
            //跳过了之后若遇到0就是与1交换
            else curr++;
        }

    }
}
