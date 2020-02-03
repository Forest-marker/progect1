package gittub;

// 题目：距离顺序排列矩阵单元格
//给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
//另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
//返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AllCellsDistOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                list.add(new int[]{i,j});
            }
        }
        Collections.sort(list,new Comparator<int[]>(){
                    @Override
                    public int compare(int[] a,int[] b){
                        return Math.abs(a[0]-r0)+Math.abs(a[1]-c0)-Math.abs(b[0]-r0)-Math.abs(b[1]-c0);
                    }
                }
        );
        //toArray() 以正确的顺序（从第一个到最后一个元素）返回一个包含此列表中所有元素的数组。
        return list.toArray(new int[][]{});
    }
}
