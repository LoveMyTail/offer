package LeetCode;

/**
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7]
 * 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 4 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * 示例 1：
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
 */
public class Problem153 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4,5,1};
        int i = new SolutionProblem153().findMin(nums);
        System.out.println(i);
    }
}

class SolutionProblem153 {
    public int findMin(int[] nums) {
        if (nums.length == 2)
            return nums[0]>nums[1]?nums[1] :nums[0] ;
        if (nums.length == 1)
            return nums[0];
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start+(end - start) / 2;
            if (nums[mid]<nums[end]){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return nums[start];
    }
}
