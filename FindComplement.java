package gittub;

//给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
//注意:
//给定的整数保证在32位带符号整数的范围内。
//你可以假定二进制数不包含前导零位。
public class FindComplement {
    public int findComplement(int num) {
        //思路：利用异或，把每一位分别和1异或，相同为0，不同为1
        int sum=0;
        int index=0;
        while(num!=0){
            int cnt =  num & 1;
            sum+=(1-cnt)*Math.pow(2,index);
            index++;
            num=num>>1;
        }
        return sum;
    }
}
