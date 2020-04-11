package DayOverDay_parctice.DayEleven;

public class Main {
    public static void main(String[] args) {
        String a="9_He$llo*world";
        int r=0;
        int i=2;
        switch(i){
            case 1:
                r=r+i;
            case 2:
                r=r+i*2;
            case 3:
                r=r+i*3;
        }
        System.out.println(r);
        java.util.HashMap map=new java.util.HashMap();
        map.put("name",null);
        map.put("name","jack");
        System.out.println(map.size());

        Thread t=new Thread(){
            public void run(){
                pong();
            }
        };
        t.run();
        System.out.println("ping");
    }
    static void pong(){
        System.out.println("pong");
    }
}
