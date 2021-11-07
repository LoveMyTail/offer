package LeetCode;

/**
 * 给你一个整数 num 。你可以对它进行如下步骤恰好 两次 ：
 * 选择一个数字 x (0 <= x <= 9).
 * 选择另一个数字 y (0 <= y <= 9) 。数字 y 可以等于 x 。
 * 将 num 中所有出现 x 的数位都用 y 替换。
 * 得到的新的整数 不能 有前导 0 ，得到的新整数也 不能 是 0 。
 * 令两次对 num 的操作得到的结果分别为 a 和 b 。
 * 请你返回 a 和 b 的 最大差值 。
 * 示例 1：
 * 输入：num = 555
 * 输出：888
 * 解释：第一次选择 x = 5 且 y = 9 ，并把得到的新数字保存在 a 中。
 * 第二次选择 x = 5 且 y = 1 ，并把得到的新数字保存在 b 中。
 * 现在，我们有 a = 999 和 b = 111 ，最大差值为 888
 */
public class Problem1432 {
    public static void main(String[] args) {
        int num = new SolutionProblem1432().maxDiff(111);
        System.out.println(num);
    }
}

class SolutionProblem1432 {
    public int maxDiff(int num) {
        char[] charsOne = String.valueOf(num).toCharArray();
        char[] charsTwo = charsOne.clone();
        for (int i = 0; i < charsOne.length; i++) {
            if (charsOne[i] != '9') {
                int cur = charsOne[i];
                for (int j = i; j < charsOne.length; j++) {
                    //System.out.println("charsOne[j]:"+charsOne[j]+" charsOne[i]:"+charsOne[i]);
                    if (charsOne[j] == cur) {
                        charsOne[j] = '9';
                    }
                }
                break;
            }
        }
        for (int i = 0; i < charsTwo.length; i++) {
            if (charsTwo[i] != '1' && i == 0) {
                int cur = charsTwo[i];
                for (int j = i; j < charsTwo.length; j++) {
                    if (charsTwo[j] == cur)
                        charsTwo[j] = '1';
                }
                break;
            } else if (i != 0 && charsTwo[i] != '0' && charsTwo[i] != '1') {
                int cur = charsTwo[i];
                for (int j = i; j < charsTwo.length; j++) {
                    if (charsTwo[j] == cur)
                        charsTwo[j] = '0';
                }
                break;
            }

        }
        return method(charsOne) - method(charsTwo);
    }

    private int method(char[] chars) {
        int cur = 0;
        for (int i = 0; i < chars.length; i++) {
            cur = cur * 10 + (chars[i] - '0');
        }
        return cur;
    }
}
