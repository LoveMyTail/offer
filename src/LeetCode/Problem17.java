package LeetCode;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 2-abc    3-def   4-ghi    5-jkl   6-mno   7-pqrs   8-tuv   9-wxyz
 */
public class Problem17 {
    public static void main(String[] args) {
        LinkedList<TreeNode> queue = new LinkedList<>();

    }
}
class SolutionProblem17 {
    List<String> list = new ArrayList<>();
    HashMap<Character,String> map = new HashMap<Character,String>(){{
        put('2',"abc");
        put('3',"def");
        put('4',"ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return list;
        backTrack(digits,0,new StringBuffer());
        return list;
    }

    private void backTrack(String digits, int index, StringBuffer sb) {
        if (index == digits.length())
            list.add(sb.toString());
        else{
            char c = digits.charAt(index);
            String s = map.get(c);
            int len = s.length();
            for (int i = 0; i < len; i++) {
                sb.append(s.charAt(i));
                backTrack(digits,index+1,sb);
                sb.deleteCharAt(index);
            }
        }
    }
}
