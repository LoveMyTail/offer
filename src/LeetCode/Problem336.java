package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组 互不相同 的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， 
 * words[i] + words[j] ，可拼接成回文串。
 * 示例 1：
 * <p>
 * 输入：["abcd","dcba","lls","s","sssll"]
 * 输出：[[0,1],[1,0],[3,2],[2,4]]
 * 解释：可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 * 示例 2：
 * <p>
 * 输入：["bat","tab","cat"]
 * 输出：[[0,1],[1,0]]
 * 解释：可拼接成的回文串为 ["battab","tabbat"]
 */
public class Problem336 {
    public static void main(String[] args) {

    }
}

class SolutionProblem336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && judge(words[i], words[j])) {
                    List<Integer> r = new ArrayList<Integer>();
                    r.add(i);
                    r.add(j);
                    res.add(r);
                }
            }
        }
        return res;
    }

    public boolean judge(String a, String b) {
        int lena = a.length();
        int lenb = b.length();
        int len = lena + lenb;
        if (lena > lenb) {
            for (int i = 0; i < len / 2; i++) {
                if (lenb - i - 1 >= 0 && a.charAt(i) != b.charAt(lenb - i - 1))
                    return false;
                if (lenb - i - 1 < 0 && a.charAt(i) != a.charAt(lena + (lenb - i - 1)))
                    return false;
            }
        } else {
            for (int i = 0; i < len / 2; i++) {
                if (lena - i - 1 >= 0 && a.charAt(i) != b.charAt(lenb - i - 1))
                    return false;
                if (lena - i - 1 < 0 && b.charAt(i - lena) != b.charAt(lenb - i - 1))
                    return false;
            }
        }
        return true;
    }
}
