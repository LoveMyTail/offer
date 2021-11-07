package Offer;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 * 示例 1:
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 */
public class FiftyOne {
    public static void main(String[] args) {
        SolutionFiftyOne s = new SolutionFiftyOne();
        System.out.println(s.reversePairs(new int[]{7, 5, 6, 4}));
    }
}

/**
 * 暴力法：复杂度O（n²）
 * 利用归并排序，在每次归并的时候便可确定有多少逆序，时间复杂度O（nlogn）
 */
class SolutionFiftyOne {
    public int reversePairs(int[] nums) {
/*      暴力法会超时
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]>nums[j])
                    cur++;
            }
        }
        return cur;*/
        if (nums.length < 2)
            return 0;

        int[] copy = new int[nums.length];
        // 将原数组拷贝进辅助数组
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }
        // 创建一个辅助数组
        int[] temp = new int[nums.length];
        return reversePairs(copy, 0, nums.length - 1, temp);

    }

    /**
     * nums[left...right] 计算逆序对个数并排序
     *
     * @param nums
     * @param left
     * @param right
     * @param temp
     * @return
     */
    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right)
            return 0;
        int mid = left + (right - left) / 2;

        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }
        int crossParis = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + crossParis + rightPairs;
    }

    /**
     * nums[left...mid]有序，nums[mid+1...right]有序
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     * @return
     */
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left, j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }
}
