import java.util.ArrayList;
import java.util.List;
public class Triangle {
    public static List<List<Integer>> Solution (int nums){
        //类似二维数组
        List<List<Integer>> list=new ArrayList<>(nums);
        for(int i=0;i<nums;i++){
            //为每一行创建空间
             list.add(new ArrayList<>());
             //将每一行的第一个元素赋值为1
             list.get(i).add(1);
        }
        int i=0;
        for( i=1;i<nums;i++){
            for(int j=1;j<i;j++){
                //如果不是最后一个和第一个
                //则下一个元素为上一行前一个元素加上上一行后一个元素
                int k=list.get(i-1).get(j-1)+list.get(i-1).get(j);
                list.get(i).add(k);
            }
            //最后一个元素设为1
            list.get(i).add(1);
        }
        return list;
    }
    public static void main(String[] args){
        List<List<Integer>> list=Solution(4);
        System.out.println(list);
    }
}
