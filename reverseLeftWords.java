package Offer;

//左旋字符串
public class reverseLeftWords {
    //字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
    // 请定义一个函数实现字符串左旋转操作的功能。
    // 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

     /*public String reverseleftWords(String s, int n) {
        char[] tmp=s.toCharArray();
        char a;
        int j;
        for(int i=0;i<n;i++){
            a=tmp[0];
            for(j=0;j<s.length()-1;j++){
                tmp[j]=tmp[j+1];
            }
            tmp[j]=a;
        }
        return new String(tmp);
    }*/


    public String reverseleftWords(String s, int n) {
        String str1=s.substring(0,n);
        String str2=s.substring(n);
        StringBuilder sb=new StringBuilder();
        sb.append(str2).append(str1);
        return sb.toString();
    }
}
