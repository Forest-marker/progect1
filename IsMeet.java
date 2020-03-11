package gittub;

import java.util.Arrays;
import java.util.Comparator;

//题目：853. 车队
//N 辆车沿着一条车道驶向位于 target 英里之外的共同目的地。
//每辆车 i 以恒定的速度 speed[i] （英里/小时），从初始位置 position[i] （英里） 沿车道驶向目的地。
//一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车以相同的速度紧接着行驶。
//此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。
//车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。
//即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
//会有多少车队到达目的地?

public class IsMeet {
    //前提条件:一辆车永远不会超过前面行驶的那辆车，但它可以追上去，并于前车以相同速度接着行驶,一辆车也可以是一个队列
    //有A B C三辆车（按距离排序）若B能追上A 且C能追上B 则C也能追上A
    class Data {
        int position;
        int speed;
        Data(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }

    private boolean isMeet(Data data1, Data data2, int target) {
        //前提是已经排好序的序列，按起始位置排列
        if (data1.speed <= data2.speed) {
            //前面位置<后面位置 前面速度<后面速度 返回false
            return false;
        }
        //计算出相遇时间
        double t = (data2.position - data1.position) * 1.0 / (data1.speed - data2.speed);
        //看相遇位置是否小于等于目的地位置，若是返回true 否则为false;
        return data1.speed * t + data1.position <= target;
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        if (len == 0) {
            return 0;
        }
        Data[] datas = new Data[len];

        for (int i = 0; i < len; i++) {
            //建立对象数组（起始位置，速度)
            datas[i] = new Data(position[i], speed[i]);
        }

        //按起始位置升序排列
        Arrays.sort(datas, Comparator.comparingInt(o -> o.position));

        int ans = 1;
        Data frontCar = datas[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            //调用isMeet如果是false 则自成一个车队ans++
            //由于题目描述一辆车永远不会超过前面的另一辆车 则就不用考虑比这辆车位置小的车辆
            //继续已下一辆车为基准，向前推进
            //反之若为true说明两辆车能相遇，成为一个队列，继续考虑以第一个车为基准和下下一辆车判断，看是否是能相遇，若能那就是前三辆车都是一个队列依次向下寻找，反之就是前两辆车是一个对咧ans++
            if (!isMeet(datas[i], frontCar, target)) {
                ans++;
                frontCar = datas[i];
            }
        }


        return ans;
    }
}
