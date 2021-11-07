package Offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class FortyEight {
    public static void main(String[] args) {

    }
}
// 动态规划，dp[i]指的是以i为结尾的前面字符串的最长不重复字符的子字符串的长度

class SolutionFortyEight {
    public int lengthOfLongestSubstring(String s) {
        // map中存储的是字符的下标
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for (int j = 0; j < s.length(); j++) {
            // 判断该字符是否出现过，如果出现过则返回其下标，否则为-1
            int i = dic.containsKey(s.charAt(j)) ? dic.get(s.charAt(j)) : -1; // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            // j-i表示当前出现的字符是否是在以当前字符为结尾的最长不重复子串中
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }
}
