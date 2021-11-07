package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * 你可以按任意顺序返回答案。
 * 示例 1：
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 */
public class Problem1002 {
}

class SolutionProblem1002 {
    List<String> list = new ArrayList<>();

    public List<String> commonChars(String[] A) {
        int[] array = new int[26];
        Arrays.fill(array, Integer.MAX_VALUE);
        for (String word: A) {
            int[] cur = new int[26];
            int length = word.length();
            for (int i = 0; i < length; ++i) {
                char ch = word.charAt(i);
                ++cur[ch - 'a'];
            }
            for (int i = 0; i < 26; ++i) {
                array[i] = Math.min(array[i], cur[i]);
            }
        }

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < array[i]; ++j) {
                list.add(String.valueOf((char) (i + 'a')));
            }
        }
        return list;

    }
}
