package Offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 */
public class ThirtyEight {
    public static void main(String[] args) {
        String str = "abcc";
        SolutionThirtyEight s = new SolutionThirtyEight();
        String[] strings = s.permutation(str);
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + " ");
        }
    }
}

class SolutionThirtyEight {
    List<String> res = new LinkedList<>();
    char[] chars;

    public String[] permutation(String s) {
        if (s == null)
            return null;
        if (s.length() == 0)
            return new String[]{};
        chars = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(int x) {
        if (x == chars.length - 1) {
            res.add(String.valueOf(chars));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < chars.length; i++) {
            if (set.contains(chars[i]))
                continue;
            set.add(chars[i]);
            swap(i, x);
            dfs(x + 1);
            swap(i, x);
        }
    }

    private void swap(int i, int x) {
        char temp = chars[i];
        chars[i] = chars[x];
        chars[x] = temp;
    }

}
