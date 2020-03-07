package arry;

//1103:分糖果II
public class DistributeCandies {
    public int[] distributeCandies(int candies, int num_people) {
        //每一次前面的糖果比后面多一个，全部发完，又从前面开始，直至刚好没有糖果
        int[] ans = new int[num_people];
        int i = 0;
        while (candies != 0) {
            ans[i % num_people] += Math.min(candies, i + 1);
            candies -= Math.min(candies, i + 1);
            i += 1;
        }
        return ans;
    }
}
