package Offer;

/**
 * 问题一：
 * 统计一个数字在排序数组中出现的次数。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 问题二：
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 */
public class FiftyThree {
    public static void main(String[] args) {
        int[] array = {5,7,7,8,8,10};
        System.out.println(new SolutionFiftyThree().search(array, 8));
        int[] cur = {0,1,2,3,4,5,6,7,9};
        System.out.println(new SolutionFiftyThreeProblem2().missingNumber(cur));
    }
}

// 二分搜索
class SolutionFiftyThree {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int count = 0;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            }
            if (nums[mid] < target)
                left = mid + 1;
        }
        while (left < nums.length) {
            if (nums[left]==target){
                count++;
                left++;
            }else{
                break;
            }
        }
        return count;
    }
}

// 二分法同理，只不过判断条件变了
class SolutionFiftyThreeProblem2 {
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == mid)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;

    }
}
