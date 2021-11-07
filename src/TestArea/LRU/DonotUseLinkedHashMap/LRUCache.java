package TestArea.LRU.DonotUseLinkedHashMap;

import java.util.HashMap;

public class LRUCache {
    @Override
    public String toString() {
        return "LRUCache{" +
                "capacity=" + capacity +
                ", map=" + map +
                ", head=" + head +
                ", end=" + end +
                '}';
    }

    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = null;
    Node end = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return -1;
    }

    public void remove(Node n) {
        if (n.pre != null) {
            n.pre.next = n.next;
        } else {
            head = n.next;
        }
        if (n.next != null) {
            n.next.pre = n.pre;
        } else {
            end = n.pre;
        }
    }

    public void setHead(Node n) {
        n.next = head;
        n.pre = null;

        if (head != null)
            head.pre = n;

        head = n;

        if (end == null)
            end = head;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            Node created = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
                setHead(created);
            } else {
                setHead(created);
            }

            map.put(key, created);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        //TestArea.LRU.UseLinkedHashMap.LRUCache<String, Integer> lruCache = new TestArea.LRU.UseLinkedHashMap.LRUCache<>(3);
        lruCache.set(1,1);
        lruCache.set(2,2);
        lruCache.set(3,3);
        lruCache.set(2,4);
        System.out.println(lruCache);
        lruCache.set(1,5);
        System.out.println(lruCache);
        lruCache.set(4,6);
        lruCache.set(5,7);
        lruCache.set(6,8);
        lruCache.set(7,9);
        System.out.println(lruCache);
    }
}
class Node {
    int key;
    int value;
    Node pre;
    Node next;
    public Node(int key,int value){
        this.key = key;
        this.value = value;
    }
}
