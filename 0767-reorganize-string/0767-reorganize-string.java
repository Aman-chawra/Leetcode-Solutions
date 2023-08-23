import java.util.*;
class Solution {
    public String reorganizeString(String s) {
        Integer n=s.length();
        if(n==null||n==0||n==1)
            return s;
        StringBuilder res=new StringBuilder();
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++)
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Character,Integer>>() {
            @Override
            public int compare(Map.Entry<Character,Integer> a, Map.Entry<Character,Integer> b) {
                return b.getValue()-a.getValue();
            }
        });
        pq.addAll(map.entrySet());
        Map.Entry<Character,Integer> prev =  new AbstractMap.SimpleEntry<Character,Integer>('#',-1);
        while(!pq.isEmpty()) {
            Map.Entry e= pq.poll();
            res.append(e.getKey());
            if(prev.getValue()>0) {
                pq.add(prev);
            }
            int freq=(int) e.getValue()-1;
            e.setValue(freq);
            prev=e;
        }
        if(res.length()==n)
            return res.toString();
        return "";
        
    }
}