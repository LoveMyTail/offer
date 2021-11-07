package LeetCode;

/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * 示例 1：
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 */
public class Problem844 {
    public static void main(String[] args) {
        String S = "a#c", T = "b";
        System.out.println(new SolutionProblem844().backspaceCompare(S, T));
    }
}

class SolutionProblem844 {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int cur1 = 0, cur2 = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#' && sb1.length() != 0) {
                sb1.deleteCharAt(cur1-1);
                cur1--;
            } else if (S.charAt(i) == '#' && sb1.length() == 0) {
                continue;
            } else {
                sb1.append(S.charAt(i));
                cur1++;
            }
        }
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#' && sb2.length() != 0) {
                sb2.deleteCharAt(cur2-1);
                cur2--;
            } else if (T.charAt(i) == '#' && sb2.length() == 0) {
                continue;
            } else {
                sb2.append(T.charAt(i));
                cur2++;
            }
        }
        //System.out.println(sb1.toString());
        //System.out.println(sb2.toString());
        return sb1.toString().equals(sb2.toString());
    }
}
