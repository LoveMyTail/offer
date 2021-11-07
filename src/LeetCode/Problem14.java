package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 */
public class Problem14 {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(new SolutionProblem14().longestCommonPrefix(strs));
    }
}

class SolutionProblem14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return null;
        if (strs.length == 1)
            return strs[0];
        // 长度由小到大排序
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        String cur = method(strs[0], strs[1]);
        System.out.println(cur);
        for (int i = 2; i < strs.length; i++) {
            cur = method(cur, strs[i]);
        }
        return cur;
    }

    private String method(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)){
                return a.substring(0, i );
            }

        }
        return a;
    }
}
