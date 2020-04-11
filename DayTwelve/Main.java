package DayOverDay_parctice.DayTwelve;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;

abstract interface bb{

}
public class Main implements bb{
    public static void add(Byte b){
        b=b++;
    }
    public int[] exchangeAB(int[] AB) {
        // write code here
        AB[0]=AB[0]+AB[1]-(AB[1]=AB[0]);
        return AB;
    }
    public static void test(){
        Byte a=127;
        Byte b=127;
        add(++a);
        System.out.println(a);
        add(b);
        System.out.println(b);
    }
    public static void main(String[] args) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(null,1);
        map.put(1,null);
        map.put(2,1);
        map.put(1,1);
        //st();
        //int 8edds;
        //int _qds joj;
        //int kow*jlkjl;
        int ajij$sewe;
       // grt();
        getGray(4);
    }
    public static String[] getGray(int n) {
        //生成格雷码，找规律，会发现第一个和最后一个总是差一个1，第二个和倒数第二个差一个1，直至所有格雷码都找出来
        //要求递归，则n+1位格雷码，是在n位格雷码上的基础上进行变换得到的，就是找到了n,就可以找到n+1,就可以递归了
        int len=(int)Math.pow(2,n);
        String[] res = new String[len];
        if(n == 1){
            res[0] = "0";
            res[1] = "1";
            return res;
        }
        String[] next = getGray(n-1);
        System.out.println(Arrays.toString(next));
        for(int i=0; i<next.length; i++){
            res[i] = "0"+next[i];
            System.out.println(i+" "+res[i]+" "+next[i]);
            res[res.length-i-1] = "1"+next[i];
            System.out.println(res.length-i-1+" "+res[res.length-i-1]+" "+next[i]);
        }
        return res;
    }

    public static  void grt(){
        /*try{
            File file=new File("ll.tex");
        }catch(java.io.FileNotFoundException ex){
            System.out.println("FileNot");
        }catch(java.io.IOException ex){
            System.out.println("IOException");
        }catch(java.lang.Exception ex){
            System.out.println("Exception");
        }*/
        String str1="hello";
        String str2="he"+new String("llo");
        System.err.println(str1==str2);
    }
}
abstract class A{
    public int abs;

    abstract void b();
    void C(){

    }
    int a;

}
