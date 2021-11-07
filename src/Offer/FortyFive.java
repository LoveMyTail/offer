package Offer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 示例 1
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 */
public class FortyFive {
    public static void main(String[] args) {

//        String s1="30";
//        String s2 = "3";
//        System.out.println(s1+s2);

        SolutionFortyFive s = new SolutionFortyFive();
        int[] ints = {3, 30, 34, 5, 9};
        String str = s.minNumber(ints);
        System.out.println(str);
    }
}

class SolutionFortyFive {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for (String s : strs)
            res.append(s);
        return res.toString();

    }
}
