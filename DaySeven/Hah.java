package DayOverDay_parctice.DaySeven;

public class Hah {
    private static int x=100;

    public static void main(String[] args) {
        Hah h1=new Hah();
        h1.x++;
        Hah h2=new Hah();
        h2.x++;
        h1=new Hah();
        h1.x++;
        Hah.x--;
        //102
        System.out.println("x="+x);

    }
}
