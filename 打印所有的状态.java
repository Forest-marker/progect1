package Thread;

public class 打印所有的状态 {
    public static void main(String[] args) {
        Thread.State[] states=Thread.State.values();
        for(Thread.State state:states){
            System.out.println(state);
        }
    }
}
