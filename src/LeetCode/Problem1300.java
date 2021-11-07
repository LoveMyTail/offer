package LeetCode;

import java.util.Arrays;

/**
 * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，
 * 使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
 * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
 * 请注意，答案不一定是 arr 中的数字。
 * 示例 1：
 * 输入：arr = [4,9,3], target = 10
 * 输出：3
 * 解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
 * 示例 2：
 * 输入：arr = [2,3,5], target = 10
 * 输出：5
 * 示例 3：
 * 输入：arr = [60864,25176,27249,21296,20204], target = 56803
 * 输出：11361
 */
public class Problem1300 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.binarySearch(arr, 9));
    }
}
// 利用Arrays.binarySearch(array, num)查找num在array中的下标
class SolutionProblem1300 {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int length = arr.length;
        int[] prefix = new int[length + 1];
        for (int i = 1; i <= length; ++i) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        int l = 0, r = arr[length - 1], num = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int index = Arrays.binarySearch(arr, mid);
            if (index < 0) {
                index = -index - 1;
            }
            int cur = prefix[index] + (length - index) * mid;
            if (cur <= target) {
                num = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        int chooseSmall = check(arr, num);
        int chooseBig = check(arr, num + 1);
        return Math.abs(chooseSmall - target) <= Math.abs(chooseBig - target) ? num : num + 1;
    }

    public int check(int[] arr, int x) {
        int ret = 0;
        for (int num : arr) {
            ret += Math.min(num, x);
        }
        return ret;
    }

}
