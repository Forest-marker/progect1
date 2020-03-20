package gittub;
//389. 找不同
//给定两个字符串 s 和 t，它们只包含小写字母。
//字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
//请找出在 t 中被添加的字母。
public class FindTheDifference {
     /*public char findTheDifference(String s, String t) {
        char ans = t.charAt(t.length()-1);
        for(int i = 0; i < s.length(); i++) {
            ans ^= s.charAt(i);
            ans ^= t.charAt(i);
        }
        return ans;
    }*/

    /*public static char findTheDifference(String s, String t) {
    int sCount = 0;
    int tCount = 0;
    for (Character c : s.toCharArray()) {
        sCount += c;
    }

    for (Character c : t.toCharArray()) {
        tCount += c;
    }

    return (char)(tCount - sCount);
}*/


    public static char findTheDifference(String s, String t) {
        int[] record = new int[26];
        int lenS = s.length();
        int lenT = t.length();
        for (int i = 0; i < lenS; i++){
            record[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < lenT; i++){
            record[t.charAt(i) - 'a'] -= 1;
            if (record[t.charAt(i) - 'a'] < 0) return t.charAt(i);

        }

        return ' ';

    }

}
