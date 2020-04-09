package javaError;

public class 堆区栈区 {
    /*
    下列java代码中的变量a,b,c分布在内存的那个区域？
    答案：堆区，栈区，栈区
分析：首先我们知道‘虚拟机栈’就是为了给方法调用时存储‘局部变量表’等的，
所以b,c无疑是位于栈区的。而堆区是存储对象的，当然对像的属性a，也位于堆区。
     */
    private String a = "aa";
    public void methodB() {
        String b = "bb";
        final String c = "cc";
    }
}
