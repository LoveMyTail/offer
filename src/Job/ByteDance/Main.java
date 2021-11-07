package Job.ByteDance;

import java.util.*;

/**
 * 给一个长度为n的字母串，只包含小写，你对修改m个位置的字母，修改完毕后你要选取这个字母串的一个
 * 连续结果满足这个子串值存在一种字母，这个子串就是一个完美字母串。要求得到的完美字母串尽可能的长，
 * 请你计算出所能得到的最长长度是多少？
 * 输入:n,m，一个长度为n的字母串
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int m = sc.nextInt();
        int i = new SolutionMain().characterReplacement(str, m);
        System.out.println(i);
    }
}
// 滑动窗口
class SolutionMain {
    private int[] map = new int[26];
    public int characterReplacement(String s, int k) {
        if (s == null) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int historyCharMax = 0;
        for (right = 0; right < chars.length; right++) {
            int index = chars[right] - 'a';
            map[index]++;
            historyCharMax = Math.max(historyCharMax, map[index]);
            if (right - left + 1 > historyCharMax + k) {
                map[chars[left] - 'a']--;
                left++;
            }
        }
        return chars.length - left;
    }
}
