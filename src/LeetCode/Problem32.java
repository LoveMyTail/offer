package LeetCode;

import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 示例 1:
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class Problem32 {
    public static void main(String[] args) {

    }
}
// 栈
class SolutionProblem32 {
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else{
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else {
                    maxLength = Math.max(maxLength,i-stack.peek());
                }
            }
        }
        return maxLength;
    }
}
