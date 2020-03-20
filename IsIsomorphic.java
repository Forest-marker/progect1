package gittub;

import java.util.HashMap;

//205. 同构字符
//给定两个字符串 s 和 t，判断它们是否是同构的。
//如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
//所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
public class IsIsomorphic {

    public boolean Isomorphic(String s, String t) {
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    private boolean isIsomorphicHelper(String s, String t) {
        //思路将首次出现的s中的字符的值赋值给t中相对应位置的字符，再遇见相同的判断此时map中对应的value值是否和此时s对应的字符值相同
        //为了避免遗漏，应该再交换赋值字符串，再相同遍历一次
        //例如 egg add
        //edd egd 判断最后一个的value值是否和g相等
        int n = s.length();
        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                map.put(c1, c2);
            }
        }
        return true;
    }
//下面这个方法是错的
//刚开始是遍历一次错误，后面交替再遍历一次，思路大致正确，但是注意题目给出的示例都是字母，但实际还是不只是26个字母
//此处char tmp=new char[26]太过于狭小
/*private boolean isIsomorphicHelper(String s, String t){
    char[] tmp=new char[26];
    Arrays.fill(tmp,'1');
    for(int i=0;i<s.length();i++){
        char s1=s.charAt(i);
        char t1=t.charAt(i);
        if(tmp[t1-'a']=='1'){
            tmp[t1-'a']=s1;
        }else{
            if(tmp[t1-'a']!=s1){
                return false;
            }
        }
    }
    return true;
}*/

//借鉴别人的代码，很巧妙
//既避免了不同字符的映射，也可以验证相同的字符映射是否正确
 /*public boolean isIsomorphic(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            //indexOf()是否有此字符，有就返回字符第一次出现的位置，没有就返回-1
            if(s.indexOf(ch1[i]) != t.indexOf(ch2[i])){
                return false;
            }
        }
        return true;
    }*/

    //s,t的映射都为0
    //例如:egg add
    //1gg 1dd
    //12g 12d
    //122 122
    //例如:foo bar
    //1oo 1ar ->12o 12r->122 12o此时o r的映射不相同，返回false
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int[] mapS = new int[128];
        int[] mapT = new int[128];
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            //当前的映射值是否相同
            if (mapS[c1] != mapT[c2]) {
                return false;
            } else {
                //是否已经修改过，修改过就不需要再处理
                if (mapS[c1] == 0) {
                    mapS[c1] = i + 1;
                    mapT[c2] = i + 1;
                }
            }
        }
        return true;
    }
}
