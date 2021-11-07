package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。
 * 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：
 * s 是一个尽可能长的快乐字符串。
 * s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
 * s 中只含有 'a'、'b' 、'c' 三种字母。
 * 如果不存在这样的字符串 s ，请返回一个空字符串 ""。
 * 示例 1：
 * 输入：a = 1, b = 1, c = 7
 * 输出："ccaccbcc"
 * 解释："ccbccacc" 也是一种正确答案。
 */
public class Problem1405 {
    public static void main(String[] args) {
//        int i = 1;
//        if (i-- > 0)
//            System.out.println("yes");
//        System.out.println(i);
        System.out.println(new SolutionProblem1405Two().longestDiverseString(2, 4, 1));
    }
}

// 贪心
class SolutionProblem1405 {
    public String longestDiverseString(int a, int b, int c) {
        // 自定义的数组对象
        MyChar[] myChars = new MyChar[]{
                new MyChar('a', a),
                new MyChar('b', b),
                new MyChar('c', c),
        };
        StringBuilder sb = new StringBuilder();

        while (true) {
            Arrays.sort(myChars);
            //先放最多的, 如果上个放的2个字符串和剩余个数最多的字符相同，则放置次多的字符

            if (sb.length() >= 2 &&
                    sb.charAt(sb.length() - 1) == myChars[2].ch &&
                    sb.charAt(sb.length() - 2) == myChars[2].ch) {
                if (myChars[1].count-- > 0) {
                    sb.append(myChars[1].ch);
                } else {
                    break;
                }

            } else {
                if (myChars[2].count-- > 0) {
                    sb.append(myChars[2].ch);
                } else {
                    break;
                }
            }

        }

        return sb.toString();
    }

    private class MyChar implements Comparable {
        char ch;
        int count;

        public MyChar(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        // 此处定义compare方法，对其中的元素进行排序
        @Override
        public int compareTo(Object o) {
            MyChar other = (MyChar) o;
            return this.count - other.count;
        }
    }
}

// 使用优先队列实现-还是存在问题
class SolutionProblem1405Two {
    public String longestDiverseString(int a, int b, int c) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', a);
        map.put('b', b);
        map.put('c', c);
        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        queue.add('a');
        queue.add('b');
        queue.add('c');
        //System.out.println(queue);
        StringBuilder sb = new StringBuilder();
        // 每轮放置字符时优先先放剩余次数最多的, 如果上次放的2个字符和剩余个数最多的字符相同，则放置次多的字符
        while (true) {
            if (sb.length() >= 2
                    && sb.charAt(sb.length() - 1) == queue.peek()
                    && sb.charAt(sb.length() - 2) == queue.peek()) {
                // 当连续出现两个重复的字符以后，应该取排行第二的字符
                char curChar = queue.poll();
                int curNum = map.get(curChar);
                if (map.get(queue.peek()) > 0) {
                    sb.append(queue.peek());
                    map.put(queue.peek(), map.get(queue.peek()) - 1);
                }
                map.put(curChar, curNum);
                queue.add(curChar);
            } else {
                if (map.get(queue.peek()) > 0) {
                    sb.append(queue.peek());
                    map.put(queue.peek(), map.get(queue.peek()) - 1);
                } else {
                    break;
                }
            }
        }
        return sb.toString();
    }
}
