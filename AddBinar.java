package gittub;

 //二进制求和
//给定两个二进制字符串，返回他们的和（用二进制表示）。
//输入为非空字符串且只包含数字 1 和 0。

public class AddBinar {
    public String addBinary(String a, String b) {
        //思路把字符串转换为数字进行计算
        //若此位没有数字则添0
        //再进行相加判断有无进位
        //利用字符串进行连接最后加上进位，再进行翻转，即可得到和
        StringBuilder str=new StringBuilder();
        int up=0;
        int sum=0;
        for(int i=a.length()-1, j=b.length()-1;i>=0||j>=0;i--,j--){
            sum=up;
            //i>=0||j>=0确保所有位数相加完毕
            sum+=(i>=0?a.charAt(i)-'0':0);
            //若j<0,则说明此位没有数字，则设置为0，并与另一位相加
            //反之大于0则说明原位有数字，则把字符转换为数字，进行相加计算
            sum+=(j>=0?b.charAt(j)-'0':0);
            //相加为1 1%2-1 1/2=0
            //相加为2 2%2=0 2/2=1
            //相加为0 0%0=0 0/2=0
            //相加为3 3%2=1 3%2=1
            //%来计算本位相加的数 /计算有无进位
            str.append(sum%2);
            //计算进位
            up=sum/2;
        }
        //若有进位则加上1 若没有加上“ ”空格
        str.append(up==1?up:"");
        //则把字符串反转，因为计算是从低位开始的，字符串连接字符是从低位
        return str.reverse().toString();
    }
}
