package Map;

import java.util.*;

public class TopKFrequent {
    //统计前k个高频单词，若两个单词出现次数一样，则按单词顺序排列
    public List<String> topKfrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        //统计单词出现的个数
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        //建大堆:kv数据
        PriorityQueue<Map.Entry<String,Integer>> pq=new PriorityQueue<>(new EntryComparator());
        for(Map.Entry<String,Integer> en:map.entrySet()){
            //入队
            pq.offer(en);
        }
        //取出大堆中的前k个元素
        List<String> list=new ArrayList<>();
        while(k--!=0){
            list.add(pq.poll().getKey());
        }
        return list;
    }
}

class EntryComparator implements Comparator<Map.Entry<String,Integer>>{
    @Override
    //实现大堆
    public int compare(Map.Entry<String,Integer> o1,Map.Entry<String,Integer> o2){
        int  diff=o2.getValue()-o1.getValue();
        if(diff==0){
            return o1.getKey().compareTo(o2.getKey());
        }
        return diff;
    }
}

/*public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map=new HashMap<>();
        for(String s:words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        //排序
        //返回key的所有不重复集合keySet()
        List<String> candidates = new LinkedList(map.keySet());
        Collections.sort(candidates, (w1, w2) -> map.get(w1).equals(map.get(w2)) ?
                w1.compareTo(w2) : map.get(w2) - map.get(w1));
        //返回前k个元素
        return candidates.subList(0, k);

    }*/