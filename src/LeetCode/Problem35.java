package LeetCode;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 */
public class Problem35 {
    public static void main(String[] args) {
        System.out.println(2>>1);
        int[] array = {1, 3, 5, 7};
        System.out.println(new SolutionProblem35().searchInsert(array, 2));
    }
}

class SolutionProblem35 {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, cur = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                cur = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return cur;
    }

}
