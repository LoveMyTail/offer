package Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 示例 1：
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 */
public class FiftySix {
    public static void main(String[] args) {
        System.out.println(4 ^ 6);
        int[] ints = new SolutionFiftySix().singleNumbers(new int[]{1, 2, 10, 4, 1, 4, 3, 3});
        for (int num : ints) {
            System.out.print(num + " ");
        }
    }
}

class SolutionFiftySix {
    public int[] singleNumbers(int[] nums) {
        int[] array = new int[2];
        Arrays.sort(nums);
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                array[count] = entry.getKey();
                count++;
            }
            if (count == 2)
                break;
        }
        return array;

    }
}

class SolutionFiftySix2 {
    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        //得到异或结果，即为不相同两个数的异或结果sum
        for (int num : nums)
            sum ^= num;
        //得到sum的二进制的1的最低位
        int flag = (-sum) & sum;
        int result[] = new int[2];
        //分成两个组进行异或，每组异或后的结果就是不相同两个数的其中之一
        for (int num : nums) {
            if ((flag & num) == 0)
                result[0] ^= num;
            else {
                result[1] ^= num;
            }
        }
        return result;
    }
}
