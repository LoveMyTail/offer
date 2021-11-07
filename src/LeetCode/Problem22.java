package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class Problem22 {
    public static void main(String[] args) {

    }
}

class SolutionProblem22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n == 1) {
            list.add("()");
            return list;
        }
        method(list, "", 0, 0, n);
        return list;
    }

    private void method(List<String> list, String s, int count1, int count2, int n) {
        if (count1 > n || count2 > n)
            return;
        if (count1 == n && count2 == n)
            list.add(s);
        if (count1 >= count2) {
            String cur = new String(s);
            method(list, cur + "(", count1 + 1, count2, n);
            method(list, cur + ")", count1, count2 + 1, n);
        }
    }
}
