package Map;

import java.util.*;

public class TestMapSet {
    public static void testMap() {
        Map<String,String> map=new TreeMap<>();
        //Map:key不重复 value可以重复
        //插入:put:key不存在，直接插入 key如果存在，修改key对应的value
        map.put("汤姆","123");
        //System.out.println(map.get("汤姆"));
        map.put("杰瑞","456");
        map.put("汤姆","1234");
        map.put("呼啦","1234");
        //没有与key对应的value返回null
       // System.out.println(map.get("汤姆"));
        //System.out.println(map.get("呼啦"));
        //没有与key对应的value返回null
        /*
        System.out.println(map.get("丽丽"));
        System.out.println(map.getOrDefault("丽丽","0"));
        System.out.println(map.getOrDefault("汤姆","1"));
        */

        //System.out.println(map.remove("汤姆"));
        //System.out.println(map.remove("汤姆"));

        //System.out.println(map.containsKey("杰瑞"));
        //System.out.println(map.containsValue("1234"));

        System.out.println("keySet:");
        Set<String> keySet=map.keySet();
        for(String key:keySet){
            System.out.println(key);
        }

        System.out.println("values:");
        Collection<String> values=map.values();
        for(String v:values){
            System.out.println(v);
        }

        System.out.println("EntrySet");
        Set<Map.Entry<String,String>> entrySet=map.entrySet();
        for(Map.Entry<String,String> es:entrySet){
            System.out.println(es.getKey()+"--->"+es.getValue());
            }
    }
    public static void testSet(){
        Set<Integer> set=new TreeSet<>();
        set.add(10);
        set.add(1);
        set.add(2);
        set.add(-2);
        set.add(100);
        //遍历时有序
        //for each语句底部是一个迭代器
        for(Integer e:set){
            System.out.print(e+" ");
        }
        System.out.println();

        System.out.println("迭代器：搜索树的中序遍历");
        Iterator<Integer> it=set.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }

    public static void main(String[] args) {
        testSet();
        //testMap();
    }
}
