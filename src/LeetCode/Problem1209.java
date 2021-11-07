package LeetCode;

import java.util.Stack;

/**
 * 给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，
 * 使被删去的字符串的左侧和右侧连在一起。
 * 你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。
 * 在执行完所有删除操作后，返回最终得到的字符串。
 * 本题答案保证唯一。
 * 示例 1：
 * 输入：s = "abcd", k = 2
 * 输出："abcd"
 * 解释：没有要删除的内容。
 * 示例 2：
 * 输入：s = "deeedbbcccbdaa", k = 3
 * 输出："aa"
 * 解释：
 * 先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
 * 再删除 "bbb"，得到 "dddaa"
 * 最后删除 "ddd"，得到 "aa"
 */
public class Problem1209 {
}
class SolutionProblem1209 {
    public String removeDuplicates(String s, int k) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i)!=sb.charAt(i-1))
                stack.push(1);
            else{
                int cur = stack.pop()+1;
                if (cur == k){
                    sb.delete(i-k+1,i+1);
                    i = i-k;
                }else{
                    stack.push(cur);
                }
            }
        }
        return sb.toString();
    }
}
