package LeetCode;

import java.util.HashMap;

/**
 * 使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
 * 如果字符串的长度为 1 ，算法停止
 * 如果字符串的长度 > 1 ，执行下述步骤：
 * 在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，
 * 且满足 s = x + y 。
 * 随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。
 * 即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
 * 在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
 * 给你两个 长度相等 的字符串 s1 和s2，判断s2是否是s1的扰乱字符串。如果是，返回 true ；否则，返回 false 。
 */
public class Problem87 {
    public static void main(String[] args) {
        String s1 = "great",s2 = "rgeat";
        System.out.println(new SolutionProblem87().isScramble(s1, s2));
    }
}
class SolutionProblem87 {
    public boolean isScramble(String s1, String s2) {
        int len1 = s1.length(),len2 = s2.length();
        if (len1!=len2)
            return false;
        if (s1.equals(s2))
            return true;
        int n = len1;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            map.put(c2, map.getOrDefault(c2, 0) - 1);
        }
        for (Character key : map.keySet()) {
            if (map.get(key) != 0) {
                return false;
            }
        }
        for (int i = 1; i < n; i++) {
            boolean flag =
                    // S1 -> T1，S2 -> T2
                    (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) ||
                            // S1 -> T2，S2 -> T1
                            (isScramble(s1.substring(0, i), s2.substring(n - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)));
            if (flag)
                return true;
        }
        return false;
    }
}
