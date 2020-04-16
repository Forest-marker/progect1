package DayOverDay_parctice.DayFourteen;

import java.util.*;
/*
该题目的输入数据是由 10 个数字组成，表示 0 - 9 出现的次数，注意至少含有一个非0的数，0不能作为数字的开头（不符合常识）

转换：换句话说就是找到第一个出现的非0的数，输出一次，再依次从头到尾把所有包含的数字输出一次，这样的数就是满足条件的最小数

注意：一定要想到怎样存储，利于后面的输出，刚开始想到hashMap,最后发现不是很方便，数组是最好的

思路：
   除0以外1-9中按照从小到大的顺序，将最小的数字输出1次
   输出1-9中按照从小到大的顺序，将每个数子输出出现的次数（第一位输出的数字会在第一次输出的时
候减去1）
 */
public class Min {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int[] tmp=new int[10];
        int i=0;
        for(i=0;i<10;i++){
            tmp[i]=scanner.nextInt();
        }
        for(i=1;i<10;i++){
            if(tmp[i]!=0){
                System.out.print(i);
                tmp[i]--;
                break;
            }
        }
        for(i=0;i<10;i++){
            while(tmp[i]!=0){
                System.out.print(i);
                tmp[i]--;
            }
        }
    }
}
