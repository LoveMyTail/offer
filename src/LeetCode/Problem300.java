package LeetCode;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 */
public class Problem300 {
    public static void main(String[] args) {

    }
}
// 动态规划
class SolutionProblem300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int[] dp = new int[len];
        dp[0] = 1;
        int maxAns = 1;
        for(int i =1;i<len;i++){
            int maxCur = 0;
            for(int j =0;j<i;j++){
                if(nums[i]>nums[j]){
                    maxCur = Math.max(maxCur,dp[j]);
                }
            }
            dp[i] = maxCur+1;
            maxAns = Math.max(maxAns,dp[i]);
        }
        return maxAns;
    }
}
