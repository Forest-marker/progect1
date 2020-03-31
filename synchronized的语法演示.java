package Thread;

public class synchronized的语法演示 {
    public synchronized  static void staticMethod(){

    }
    public synchronized void method(){

    }
    public void somMethod(){
        Object o=new Object();
        synchronized (o){

        }
    }
}
