package Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 */
public class FiftySeven {
    public static void main(String[] args) {

    }
}
// 双指针
class SolutionFiftySeven {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length==0)
            return null;
        for (int left = 0,right = nums.length-1;left<right;){
            if ((nums[left]+nums[right])<target){
                left++;
            }else if ((nums[left]+nums[right])>target){
                right--;
            }else if ((nums[left]+nums[right])==target){
                int[] array = new int[2];
                array[0] = nums[left];
                array[1] = nums[right];
                return array;
            }
        }
        return null;
    }
}

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 方法：双指针
 */
class SolutionFiftySeven2 {
    public int[][] findContinuousSequence(int target) {
        int i = 1; // 滑动窗口的左边界
        int j = 1; // 滑动窗口的右边界
        int sum = 0; // 滑动窗口中数字的和
        List<int[]> res = new ArrayList<>();

        while (i <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += j;
                j++;
            } else if (sum > target) {
                // 左边界向右移动
                sum -= i;
                i++;
            } else {
                // 记录结果
                int[] arr = new int[j-i];
                for (int k = i; k < j; k++) {
                    arr[k-i] = k;
                }
                res.add(arr);
                // 左边界向右移动
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);

    }
}
