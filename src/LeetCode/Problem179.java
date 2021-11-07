package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * 示例 1:
 * 输入: [10,2]
 * 输出: 210
 * 示例2:
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 */
public class Problem179 {
    public static void main(String[] args) {
        int[] nums = {0,0};
        SolutionProblem179 s = new SolutionProblem179();
        System.out.println(s.largestNumber(nums));
    }
}
class SolutionProblem179 {
    public String largestNumber(int[] nums) {
        int len = nums.length;;
        String[] array = new String[len];
        for (int i = 0; i < len; i++) {
            array[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        if (array[0].equals("0"))
            return "0";
        for (String s : array) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
