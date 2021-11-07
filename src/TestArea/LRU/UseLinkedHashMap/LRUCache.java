package TestArea.LRU.UseLinkedHashMap;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LRUCache {

    private int capacity;
    private Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        int value = map.remove(key);
        map.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
            return;
        }
        map.put(key, value);
        if (map.size() > capacity) {
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1,1);
        System.out.println(cache);
        cache.put(2,2);
        System.out.println(cache);
        cache.put(3,3);
        System.out.println(cache);
        cache.put(4,4);
        System.out.println(cache);
        cache.put(5,5);
        System.out.println(cache);

    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "capacity=" + capacity +
                ", map=" + map +
                '}';
    }
}
