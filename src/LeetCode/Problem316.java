package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * 示例 1:
 * 输入: "bcabc"
 * 输出: "abc"
 * 示例 2:
 * 输入: "cbacdcbc"
 * 输出: "acdb"
 */
public class Problem316 {
    public static void main(String[] args) {
        SolutionProblem316 s = new SolutionProblem316();
        System.out.println(s.removeDuplicateLetters("cbacdcbc"));
    }
}

class SolutionProblem316 {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();

        // this lets us keep track of what's in our solution in O(1) time
        HashSet<Character> set = new HashSet<>();

        // this will let us know if there are any more instances of s[i] left in s
        HashMap<Character, Integer> last_Index = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            last_Index.put(s.charAt(i), i);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // we can only try to add c if it's not already in our solution
            // this is to maintain only one of each character
            if (!set.contains(c)) {
                // if the last letter in our solution:
                //     1. exists
                //     2. is greater than c so removing it will make the string smaller
                //     3. it's not the last occurrence
                // we remove it from the solution to keep the solution optimal
                while (!stack.isEmpty() && c < stack.peek() && last_Index.get(stack.peek()) > i) {
                    set.remove(stack.pop());
                }
                set.add(c);
                stack.push(c);
            }
            System.out.println(stack);
        }
        StringBuilder sb = new StringBuilder(stack.size());
        for (Character c : stack)
            sb.append(c.charValue());
        return sb.toString();

    }
}
