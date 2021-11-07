package LeetCode;

/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，
 * 并且长度不超过10000。
 */
public class Problem459 {
    public static void main(String[] args) {

    }
}

class SolutionProblem459 {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = 1; i * 2 <= len; ++i) {
            if (len % i == 0) {
                boolean match = true;
                for (int j = i; j < len; ++j) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }
}

class SolutionProblem459Two {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
