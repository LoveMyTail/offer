package Job.Tencent.Interview;

import java.util.HashMap;
import java.util.LinkedList;

public class LRU {
    /**
     * ["LRUCache","put","put","put","put","get","get"]
     * [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
     *
     * @param args
     */
    public static void main(String[] args) {
        LRU lru = new LRU(2);
        lru.put(2, 1);
        System.out.println(lru);
        lru.put(1, 1);
        System.out.println(lru);
        lru.put(2, 3);
        System.out.println(lru);
        lru.put(4, 1);
        System.out.println(lru);
        System.out.println(lru.get(1));
        System.out.println(lru);
        System.out.println(lru.get(2));
        System.out.println(lru);
//        lru.put(1, 1);
//        lru.put(4, 1);
//        System.out.println(lru);
//        System.out.println(lru.get(2));
    }

    private LinkedList<Integer> list;
    private int capacity;
    private HashMap<Integer, Integer> map;

    public LRU(int capacity) {
        this.capacity = capacity;
        list = new LinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            int index = list.indexOf(key);  // 时间复杂度O（n）
            list.remove(index);
            list.addFirst(key);
            return map.get(key);
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            if (list.size() == 1) {
                map.put(key, value);
            } else {
                list.remove(Integer.valueOf(key));
                map.put(key, value);
                list.addFirst(key);
            }
        } else {
            list.addFirst(key);
            map.put(key, value);
        }
        if (list.size() > capacity) {
            // 此处获取到的是Integer类型的变量，所以说这是key，而不是下标值
            Integer last = list.getLast();
            list.remove();
            map.remove(last);
        }
    }

    @Override
    public String toString() {
        return "LRU{" +
                "list=" + list +
                ", capacity=" + capacity +
                ", map=" + map +
                '}';
    }
}
