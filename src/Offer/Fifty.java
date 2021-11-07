package Offer;

import java.util.*;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 * 示例:
 * s = "abaccdeff"
 * 返回 "b"
 * s = ""
 * 返回 " "
 * 限制：
 * 0 <= s 的长度 <= 50000
 */
public class Fifty {
    public static void main(String[] args) {
//        HashMap<Character,Integer> map = new HashMap<>();
//        map.put('a',2);
//        map.put('c',1);
//        map.put('e',3);
//        map.put('d',0);
//        map.put('a',5);
//        System.out.println(map);
        String s = "leetcode";
        SolutionFifty solutionFifty = new SolutionFifty();
        System.out.println(solutionFifty.firstUniqChar(s));
    }
}

/**
 * 可以利用哈希表 HashMap<Character,boolean> 如果是第一次则为true，多次则为false
 *
 */
class SolutionFifty {
    public char firstUniqChar(String s) {
        if (s.length() == 0) {
            return ' ';
        } else if (s.length() == 1) {
            return s.charAt(0);
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i],map.get(chars[i])+1);
            }else{
                map.put(chars[i],1);
            }
        }
        System.out.println(map);
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            //System.out.println("key:" + entry.getKey() + "   value:" + entry.getValue());
            if (entry.getValue()==1)
                return entry.getKey();
        }
        return ' ';
    }
}
