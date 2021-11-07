package LeetCode;

/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 示例:
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 */
public class Problem238 {
    public static void main(String[] args) {

    }
}

class SolutionProblem238 {
    public int[] productExceptSelf(int[] nums) {
        int left = 1;
        int right = 1;
        int len = nums.length;
        int[] output = new int[len];
        for(int i=0;i<len;i++){
            output[i] = left;
            left *= nums[i];
        }
        for(int j=len-1;j>=0;j--){
            output[j] *= right;
            right *= nums[j];
        }
        return output;

    }
}
