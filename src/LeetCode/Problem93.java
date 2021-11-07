package LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 * 示例:
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class Problem93 {
    public static void main(String[] args) {

    }
}

class SolutionProblem93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        int len = s.length();
        backtrack(0, "", 4, s, list, len);
        return list;
    }

    private void backtrack(int i, String temp, int flag, String s, List<String> list, int len) {
        if (i == len && flag == 0) {
            list.add(temp.substring(0, temp.length() - 1));
            return;
        }
        if (flag < 0)
            return;
        for (int j = i; j < i + 3; j++) {
            if (j < len) {
                if (i == j && s.charAt(j) == '0') {
                    backtrack(j + 1, temp + s.charAt(j) + ".", flag - 1, s, list, len);
                    break;
                }
                if (Integer.parseInt(s.substring(i, j + 1)) <= 255)
                    backtrack(j + 1, temp + s.substring(i, j + 1) + ".", flag - 1, s, list, len);
            }
        }
    }
}
