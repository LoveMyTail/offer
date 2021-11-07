package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 给定一个非空的整数数组，返回其中出现频率前k高的元素。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 */
public class Problem347 {
    public static void main(String[] args) {
        int[] array = {1, 1, 1, 2, 2, 3, 4, 3, 1, 5, 63, 1, 2, 4, 4, 4, 4, 4, 3, 3, 3, 2, 2, 2};
        SolutionProblem347 s = new SolutionProblem347();
        int[] ints = s.topKFrequent(array, 3);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }
}

class SolutionProblem347O {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            //当Map集合中有这个key时，就使用这个key值，如果没有就使用默认值defaultValue
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(map);
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));
        for (Integer integer : map.keySet()) {
            if (heap.size() < k) {
                heap.add(integer);
            } else if (map.get(integer) > map.get(heap.peek())) {
                System.out.println(heap);
                heap.remove();
                System.out.println(heap);
                heap.add(integer);
                System.out.println(heap);
            }
        }
        int[] array = new int[k];
        int count = 0;
        while (!heap.isEmpty()) {
            array[count] = heap.poll();
            count++;
        }

        return array;
    }
}


class SolutionProblem347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((x,y)->map.get(y)-map.get(x));
        for (int num : nums) {
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        for (Integer key : map.keySet()) {
            queue.add(key);
        }
        int[] array = new int[k];
        for (int i = 0; i < k; i++) {
            array[i] = queue.poll();
        }
        return array;
    }
}
