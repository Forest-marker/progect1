package DayOverDay_parctice.DayNine;

import java.util.Scanner;

public class Main2 {
    //5 (5 4 3 2 1) 6 7 8 9 10(10*9*8*7*6*5*4*3*2*1)
    //5*单位数一个0 (0-19) 20(100) 30(150) 40(200) 50(250) 60(300)
    //70(350) 80(400) 90(450) 100(500) 110(550) 112(
    //20 20 19 18 17 16 15 14 13 11
    //
    //此数有几个0，看与0最接近的哪个数是否偶数，是偶数+1
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n < 5) {
            System.out.println(0);
        }
        if (n >= 5 && n < 10) {
            System.out.println(1);
        }
        int mod = 0;
        int count = 0;
        for (int i = 10; i <= n; i++) {
            int sum = i;
            while (sum > 0) {
                mod = sum % 10;
                sum = sum / 10;
                if (mod != 0) {
                    break;
                }
                if (mod == 0 && sum % 10 == 0) {
                    count++;
                } else if (mod == 0 && sum % 10 != 0) {
                    count++;
                    break;
                }
            }
            while (sum > 0) {
                mod = sum % 10;
                sum = sum / 10;
                if (mod != 0) {
                    break;
                }
                if (mod == 0 && sum % 10 == 0) {
                    count++;
                } else if (mod == 0 && sum % 10 != 0) {
                    count++;
                    break;
                }
            }
            System.out.println(count);
            //10*9*8*7*6*5*4*3*2*1 (2)*
            //5*1=1 *2=10 *4=20 *6=30
        }

        System.out.println(count);
    }

    public static int Count(int n) {
        if (n < 5) {
            return 0;
        }
        if (n >= 5 && n < 10) {
            return 1;
        }
        int mod = 0;
        int count = 0;
        for (int i = 10; i <= n; i++) {
            int sum = i;
            while (sum > 0) {
                mod = sum % 10;
                sum = sum / 10;
                if (mod != 0) {
                    break;
                }
                if (mod == 0 && sum % 10 == 0) {
                    count++;
                } else if (mod == 0 && sum % 10 != 0) {
                    count++;
                    break;
                }
            }
        }
        return count + 1;
    }


    public static int getFactorSuffixZero(int n) {
        if (n < 5)
            return 0;
        int count = 0;
        for (int i = 5; n / i > 0; i *= 5) {
            count += n / i;
            System.out.println(i + " " + count);
        }


        /*for(int i=1;i<=5;i++){
            n=n/5;
            count+=n;
        }*/


        return count;


    }
}
class test{
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        long count=0;
        for(int i=1;i<n;i++){
            n/=5;
            count+=n;
            System.out.println(i+" "+count);
        }

        System.out.println(Main2.getFactorSuffixZero(30));
        //System.out.println(count);
    }
}
