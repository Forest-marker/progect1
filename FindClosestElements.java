package Map;

import java.util.LinkedList;
import java.util.List;

//658. 找到 K 个最接近的元素
//给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
// 如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
public class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //利用双指针法
        int size = arr.length;

        int left = 0;
        int right = size - 1;

        int removeNums = size - k;
        while (removeNums > 0) {
            if (x - arr[left] <= arr[right] - x) {
                right--;
            } else {
                left++;
            }
            removeNums--;
        }

        List<Integer> res = new LinkedList<>();
        for (int i = left; i <=right; i++) {
            res.add(arr[i]);
        }
        return res;

    }
}
