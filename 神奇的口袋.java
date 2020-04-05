package DayOverDay_parctice.DayFour;

import java.util.Scanner;
//神奇的口袋(牛客)
//采用递归思想： ①物品n个，物品体积逐一放入weight[]中 ②递归函数count(int s,int n) : 其 中s为剩余物品重量，n为剩余可选的物品个数
//则分以下两步递归求解：
//a.从后往前装，装上weight[n]后，若剩余物品仍然有解
//则count(s-weight[n],n-1);
//b.若装了weight[n]后，无解，则删除该包,尝试第n-1个
//count(s,n-1);
public class Main {
    static int[] weight;
    static int N;
    static int count=0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入物品个数:");
        N = input.nextInt();
        weight = new int[N+1];
        System.out.println("请输入各个物品的重量:");
        for (int i = 1; i <= N; i++) {
            weight[i] = input.nextInt();
        }
        count(40,N);
        System.out.println(count);

    }
    public static void count(int s,int n) {
        //如果正好装满
        if(s==0) {
            ++count;
            return ;
        }
        //是s<0或n<1则不能完成
        if(s<0||(s>0&&n<1))
            return ;
        count(s-weight[n],n-1);
        count(s,n-1); }
}
