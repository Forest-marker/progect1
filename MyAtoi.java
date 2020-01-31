package gittub;

 //字符串转换整数 (atoi)
//请你来实现一个 atoi 函数，使其能将字符串转换成整数
public class MyAtoi {
    /* public int myAtoi(String str) {
        Queue<Character> stack=new LinkedList<>();
        for(char s:str.toCharArray()){
            if((s>='0'&&s<='9')||s=='+'||s=='-'){
                  stack.offer(s);
                  }else if(s==' '){

                  }else{
                    break;
                    }
            }
            if(stack.size()==0){
                return 0;
            }else{
                int i=stack.size()-1;
                int sum=0;
                int index=1;
                while(i>=0){
                    if(i==stack.size()-1){
                        if(stack.peek()=='-'){
                            index=-1*index;

                            }
                          if(stack.peek()=='+'){
                              index=index;

                              }
                        if(stack.peek()>='0'&&stack.peek()<='9'){
                             sum*=10;
                             sum+=(stack.poll()-'0');
                        }
                        //42 输出 2 4
                    }else{
                         sum*=10;
                         sum+=(stack.poll()-'0');
                         i--;
                        }
                        }
                        return index*sum;
            }
        }*/

    //题目意思是若有空格，则出现在开头才能去掉忽略掉
    //第一个为数字后面有空格符号其它都不行，只能数字和数字相邻才算成功
    //若第一个为符号，后面只可能相邻数字，其它都不行
    public int myAtoi(String str) {
        long res = 0;
        boolean flag = true;
        int f = -1;
        char[] c = str.toCharArray();
        for(int i = 0; i<c.length;i++) {
            if(f==-1 && (c[i]=='-' || c[i]=='+') ) {
                //判断符号 设置标志位
                flag = c[i]=='-'?false:true;
                f = 1;
            }else if(Character.isDigit(c[i])) {
                //判断是否为数字
                res = res*10 + (c[i]-'0');
                if(res>Integer.MAX_VALUE){
                    //溢出再做正数负数判断 返回值
                    if(!flag) return  Integer.MIN_VALUE;
                    return Integer.MAX_VALUE;
                }
                f = 1;
            }else if(c[i]>30 ){
                //空格
                if(f==-1 && c[i]==' ') continue;
                break;
            }
        }
        //返回正数 负数
        return flag == true?(int)res:(int)-res;
    }
}
