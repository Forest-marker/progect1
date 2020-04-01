package DayOverDay_parctice;
import java.util.Scanner;
//有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，
// 她最多可以换多少瓶汽水喝？”答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，
// 喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。
// 然后你让老板先借给你一瓶汽水，喝掉这瓶满的，
// 喝完以后用3个空瓶子换一瓶满的还给老板。如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
public class popProblem {
        public static  int Find(int n){
            int sum=0,count=0,tmp=0;
            while(n>1){
                //至少两个空瓶子可以喝到一瓶汽水，（借一瓶，再还一瓶）
                if(n==2){
                    count+=1;
                    break;
                }
                //sum为可兑换的汽水个数
                sum=n/3;
                count+=sum;
                //tmp为剩余空瓶子个数
                tmp=n%3;
                //n为下一次共有的空瓶子个数（包括兑换的瓶子喝完)
                n=sum+tmp;
            }
            return count;
        }
        public static void main(String[] args){
            Scanner scanner=new Scanner(System.in);
            while(scanner.hasNextInt()){
                int a=scanner.nextInt();
                System.out.println(Find(a));
            }
        }
    }

