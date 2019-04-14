package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
        Map map = new HashMap();
        for (int i = 0;i < 100;i++) {
           map.put(Integer.toString(i),i);
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.forEach((k,v) -> {
            System.out.println(k);
            System.out.println(v);
        });
        Set<Map.Entry<String, Integer>> entry =  hashMap.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while (iterator.hasNext()) {
             Map.Entry<String, Integer> ttt = iterator.next();
        }

        System.out.println();
    }
}
