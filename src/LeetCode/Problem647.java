package LeetCode;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 */
public class Problem647 {
}

class SolutionProblem647 {
    public int countSubstrings(String s) {
        int len = s.length(), count = 0;
        for (int i = 0; i < 2 * len - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++count;
            }
        }
        return count;
    }
}
