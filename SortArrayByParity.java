package gittub;
//按奇偶排序数组
//给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
//你可以返回满足此条件的任何数组作为答案。
public class SortArrayByParity {
    /*public int[] sortArrayByParity(int[] A) {
        int i=0;
        int j=A.length-1;
        int[] B=new int[A.length];
         for(int k=0;k<A.length;k++){
            if(A[k]%2==0){
                B[i++]=A[k];
                 }else{
                     B[j--]=A[k];
                 }
        }
        return B;
    }*/

    //原地排序
    //前是奇数，后是偶数，前后交换
    //前是偶数不换位置，标志位++
    //后是奇数，不变位置，标志位--
    public int[] sortArrayByParity(int[] A) {
        int i=0;
        int j=A.length-1;
        int temp=0;
        while(i<j){
            if(A[i]%2>A[j]%2){
                temp=A[j];
                A[j]=A[i];
                A[i]=temp;
            }
            if(A[i]%2==0){
                i++;
            }
            if(A[j]%2!=0){
                j--;
            }
        }
        return A;
    }


}
