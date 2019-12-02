package bitekeji;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
public class MapDemo {
    public static void main(String[] args){
        Map<String,String> map=new HashMap<>();
        Map<String,String> map1=new TreeMap<>();
        //TreeMap复杂度高,HahMap复杂度低，
        System.out.println(map.get("作者"));
        //根据指定的 k 查找对应的 v，没有找到用默认值代替
        System.out.println(map.getOrDefault("作者","海明威"));
        map.put("作者","鲁迅");
        map.put("书名","狂人日记");
        map.put("发布时间","1918");
       for(Map.Entry<String,String> entry:map.entrySet()){
           System.out.println(entry.getKey()+"___>"+entry.getValue());
       }
        map.getOrDefault("发布时间","1917");//已存在就修改
        map.put("页数","300");//未存在就插入
        //Set<Map.Entry<K, V>> entrySet() 将所有键值对返回
        for(Map.Entry<String,String> entry:map.entrySet() ){
            System.out.println(entry);
        }
        //根据指定的 k 查找对应的
        System.out.println(map.get("页数"));

        System.out.println(map.containsValue("海明威"));
        System.out.println(map.containsKey("鲁迅"));//是否包含key
        System.out.println(map.containsValue("狂人日记"));//是否包含value
        System.out.println(map.size());//长度
        System.out.println(map.isEmpty());//是否为空
    }
}
