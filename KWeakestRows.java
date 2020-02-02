package gittub;

import java.util.*;
 //方阵中战斗力最弱的 K 行
//给你一个大小为 m * n 的方阵 mat，方阵由若干军人和平民组成，分别用 0 和 1 表示。
//请你返回方阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
//如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
//军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。

public class KWeakestRows {
    /*public int[] kWeakestRows(int[][] mat, int k) {
        HashMap<Integer,Integer> map=new HashMap();
        for(int i=0;i<mat.length;i++){
            int count=0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    count++;
                }else{
                    break;
                }
            }
            map.put(i,count);
        }
        //利用比较器来进行比较
        List<Integer> list;
        list = new ArrayList<>(mat.length);
        for(int i=0;i<mat.length;i++){
            list.add(i);
        }
         Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //根据键名取键值
                return map.get(o1)-map.get(o2);
            }
        });
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=list.get(i);
        }
        return res;
    }*/


    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] temp = new int[mat.length][2];
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                temp[i][0] = i;
                if(mat[i][j] == 1){
                  temp[i][1]++;
                }
            }
        }
        Arrays.sort(temp,new Comparator<int[]>(){
                    public int compare(int[] a,int[] b){
                        if(a[1]==b[1]){
                            return a[0]-b[0];
                        }else{
                            return a[1]-b[1];
                        }
                    }
                }
        );
        //Arrays.sort(tmp, (o1, o2) -> o1[1] - o2[1]);
        int[] res = new int[k];
        for(int i =0; i < k; i++){
            res[i] = temp[i][0];
        }
        return res;
    }
}
