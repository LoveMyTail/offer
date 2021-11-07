package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Problem15 {
    public static void main(String[] args) {

    }
}
// 将三数之和转变为两数之和，也就是数组中是否存在A+B=-C，从中采用
class SolutionProblem15 {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] < -nums[i]) {
                    j++;
                } else if (nums[j] + nums[k] > -nums[i]) {
                    k--;
                } else {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[i]);
                    cur.add(nums[j]);
                    cur.add(nums[k]);
                    list.add(cur);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && k != nums.length - 1 && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return list;
    }

    private void method(int[] nums, List<Integer> cur, int target, int curIndex) {
        if (target == 0 && cur.size() == 3) {
            list.add(new ArrayList<>(cur));
            return;
        }
        if (target < 0 && curIndex< nums.length) {
            for (int i =curIndex;i<nums.length;i++){

            }
        }
    }
}
