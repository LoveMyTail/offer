package Job.YouZan;

import java.util.Arrays;
import java.util.Scanner;

public class MainTwo {
    public static void main(String[] args) {
        int[] nums = {1,2,4};
        SolutionMainTwo s = new SolutionMainTwo();
        System.out.println(s.minMoves(nums));

    }
}

/**
 * 输入：[1,2,4]
 * 输出：3
 * 解释：[1,2,4]---[2,2,4]---[2,2,3]---[2,2,2]
 */
class SolutionMainTwo {
    /**
     * 最少移动次数
     * @param nums int整型一维数组
     * @return int整型
     */
    public int minMoves (int[] nums) {
        int count = 0;
        int len = nums.length;
        Arrays.sort(nums);
        int temp = nums[len/2];
        for (int i = 0; i < nums.length; i++) {
            count+=(Math.abs(temp-nums[i]));
        }
        return count;

    }
}
