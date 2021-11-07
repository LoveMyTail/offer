package LeetCode;

/**
 * 实现strStr()函数。
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle
 * 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
 * 说明：
 * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当needle是空字符串时我们应当返回 0 。这与 C 语言的strstr()以及 Java
 * 的indexOf()定义相符。
 * 示例 1：
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 */
public class Problem28 {
    public static void main(String[] args) {
        String a = "a";
        String b = "a";
        System.out.println(new SolutionProblem28().strStr(a, b));
    }
}

class SolutionProblem28 {
    public int strStr(String haystack, String needle) {
        int lenFirst = haystack.length();
        int lenSecond = needle.length();
        if (lenFirst < lenSecond)
            return -1;
        int start = 0;
        int end = lenSecond - 1;
        while (end < lenFirst) {
            if (haystack.substring(start, end + 1).equals(needle))
                return start;
            end++;
            start++;
        }
        return -1;
    }
}
