package TestArea;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.*;

public class CollectionTest {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1, 1);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);

        HashMap<Integer, Integer> hashmap = new HashMap<>();

        Hashtable<Integer, Integer> hashtable = new Hashtable<>();

        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        //ThreadPoolExecutor executor = new ThreadPoolExecutor(3,3,TimeUnit.SECONDS,new LinkedBlockingQueue<TestOne>(), new Runnable() {

        HashSet<Integer> set = new HashSet<>();
        set.add(1);

        TreeSet<Integer> treeSet = new TreeSet<>();

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "a");
        treeMap.put(2, "a");

    }
}
