package LeetCode;

import java.util.HashMap;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Problem3 {
    public static void main(String[] args) {
        System.out.println(new SolutionProblem3().lengthOfLongestSubstring("abcabcaa"));
    }
}
// 动态规划/滑动窗口
class SolutionProblem3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0)
            return 0;
        int left = 0,right = 0;
        int max = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        while (right<s.length()){
            System.out.println("left:"+left+"--right:"+right);
            if (!map.containsKey(chars[right])){
                map.put(chars[right],right);
                max = Math.max(max,right-left+1);
                right++;
            }else{
                if (map.get(chars[right])>=left){
                    left = map.get(chars[right])+1;
                    map.put(chars[right],right);
                }else{
                    max = Math.max(max,right-left+1);
                    right++;
                }
            }
        }

        return max;
    }
}
