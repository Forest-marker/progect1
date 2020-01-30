package gittub;

import java.util.Arrays;
//题目：加一
//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

//最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

//你可以假设除了整数 0 之外，这个整数不会以零开头。

public class Plusone {
        public int[] plusOne(int[] digits) {
            //借鉴他人的代码，觉得十分好，思路很棒
            //特殊情况就是每位是否为9若是变为0，若全是9则会多出一位，再做处理
            for(int i=digits.length-1;i>=0;i--){
                //末尾元素加一判断是否这个元素为9，再作判断
                digits[i]++;
                //此处若为0，则设为0
                digits[i]=digits[i]%10;
                //例如19 变为20
                if(digits[i]!=0){
                    return digits;
                }
            }
            //重新赋值数组，长度改变，每个下标初始值都为0，把第一位变为1，其余为0
            digits=new int[digits.length+1];
            //此处就是每个位都是9的情况，例如99 变为100 需要多一位空间
            digits[0]=1;
            return digits;

        }
    }

