package DayOverDay_parctice.编程题;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    /*public static void main(String[] args) {
        int[] nums = new int[1000];
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            int m = scanner.nextInt();
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] == m) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }*/

    public static int print(String[] tmp,int k,int count,int start){
        Stack<String> stack1=new Stack<>();
        Stack<String> stack2=new Stack<>();
        Stack<String> stack3=new Stack<>();
        for(int j=start+count;j>start;j--){
            stack3.push(tmp[j]);
        }
        for(int i=0;i<k;i++){
            for(int j=start;j<start+count;j++){
                if(j<start+count/2){
                    stack1.push(stack3.pop());
                }else{
                    stack2.push(stack3.pop());
                }
            }
            for(int p=0;p<count/2;p++){
                stack3.push(stack2.pop());
                stack3.push(stack1.pop());
            }
        }
        int index=count;
        while(index>1){
            System.out.print(stack3.pop()+" ");
            index--;
        }
        System.out.print(stack3.pop());
        System.out.println();
        return start+count;
    }
    public static void main(String[] args){
        //3
        //1 2 3 4 5 6
        //1 2 3 4 5 6
        //1 1
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        String[] tmp=str.split(" ");
        System.out.println(Arrays.toString(tmp));
        int sum=Integer.parseInt(tmp[0]);
        int i;
        for(i=1;i<tmp.length-1;i++){
            int a=Integer.parseInt(tmp[i]);
            int b=Integer.parseInt(tmp[i+1]);
            i=print(tmp,b,a*2,i+1);
        }
    }
}
