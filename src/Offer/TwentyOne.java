package Offer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 */
public class TwentyOne {
    public static void main(String[] args) {
        SolutionTwentyOne s = new SolutionTwentyOne();
        int[] ints = s.exchange(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+" ");
        }
    }
}

class SolutionTwentyOne {
    public int[] exchange(int[] nums) {
        if (nums.length==0 ||nums.length == 1)
            return nums;
        int start = 0;
        int end = nums.length - 1;
        while (start != end) {
            if (nums[start] % 2 == 0 && nums[end] % 2 == 0) {
                end--;
            } else if (nums[start] % 2 != 0 && nums[end] % 2 != 0) {
                start++;
            } else if (nums[start] % 2 == 0 && nums[end] % 2 != 0) {
                int cur = nums[start];
                nums[start]=nums[end];
                nums[end] = cur;
                end--;
            } else {
                end--;
            }
        }
        return nums;
    }

}
