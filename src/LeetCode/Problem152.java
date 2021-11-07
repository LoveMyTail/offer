package LeetCode;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 */
public class Problem152 {
    public static void main(String[] args) {

    }
}
class SolutionProblem152 {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int max = nums[0];
        int dp_min[] = new int[length];
        int dp_max[] = new int[length];
        dp_max[0] = dp_min[0] = nums[0];
        for(int i = 1; i < length; i++){
            dp_max[i] = Math.max(dp_max[i-1]*nums[i], Math.max(dp_min[i-1]*nums[i], nums[i]));
            dp_min[i] = Math.min(dp_min[i-1]*nums[i], Math.min(dp_max[i-1]*nums[i], nums[i]));
            max = Math.max(max, dp_max[i]);
        }
        return max;
    }
}
