package LeetCode;

import java.util.*;

/**
 * 给一非空的单词列表，返回前k个出现次数最多的单词。
 *
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * 示例 1：
 *
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 */
public class Problem692 {
    public static void main(String[] args) {

    }
}
class SolutionProblem692 {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> list = new ArrayList<>();
        HashMap<String ,Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)){
                map.put(word,map.get(word));
            }else{
                map.put(word,1);
            }
        }
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1)!=map.get(o2))
                    return map.get(o2)-map.get(o1);
                else
                    return o1.compareTo(o2);
            }
        });
        for (String s : map.keySet()) {
            queue.add(s);
        }
        for (int i = 0; i < k; i++) {
            list.add(queue.poll());
        }
        return list;
    }
}
