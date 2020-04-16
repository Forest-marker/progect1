package DayOverDay_parctice.DayFourteen;

//要求：不使用临死存储空间来交换两个变量的值
public class swapNotemp {
    public void swap1(int a,int b){
        a=a^b;
        b=b^a;
        a=a^b;
        System.out.println(a+" "+b);
    }

    public void swap2(int a,int b){
        a=a+b-(b=a);
        System.out.println(a+" "+b);
    }

    public void swap3(int a,int b){
        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println(a+" "+b);
    }

    public static void main(String[] args) {
        swapNotemp p=new swapNotemp();
        int a=1,b=2;
        p.swap1(a,b);
        //形参的改变你不影响实参
        p.swap2(a,b);
        System.out.println(a+" "+b);
    }
}
