package Map;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MainMain {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String right=scanner.nextLine();
        String wrong=scanner.nextLine();

        Set<Character> wrongset=new HashSet<>();
        for(char ch : wrong.toCharArray()){
            wrongset.add(ch);
        }
        Set<Character> prinSet=new HashSet<>(0;

        for(char ch:right.toCharArray()){
            if(!wrongset.contains(ch)){
                ch=Character.toUpperCase(ch);
                if(!prinSet.contains(ch)){
                    prinSet.add(ch);
                    System.out.print(ch);
                }
            }
        }
    }

}
