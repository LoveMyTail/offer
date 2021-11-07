package LeetCode.Game;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,3,4};
        SolutionNumsGame s = new SolutionNumsGame();
        int[] ints = s.numsGame(nums);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}

class SolutionIsMagic {
    public boolean isMagic(int[] target) {
        int len = target.length;
        int[] cur = new int[len];
        for (int i = 0; i < len; i++) {
            cur[i] = i + 1;
        }
        int left = 0, right = target.length - 1;
        int[] start = new int[len];
        for (int i = 0; i < len; i++) {
            start[i] = cur[i];
        }
        return method(cur, left, right, target, start);
    }

    private boolean method(int[] cur, int left, int right, int[] target, int[] start) {
        int curLeft = 0, curRight = target.length - 1;
        while (cur[curLeft] == target[curLeft] && curLeft <= curRight) {
            curLeft++;
            if (curLeft >= target.length) {
                return true;
            }
        }
        while (cur[curRight] == target[curRight] && curLeft <= curRight) {
            curRight--;
            if (curRight <= 0)
                return true;
        }
        if (curLeft >= curRight)
            return true;
        cur = reverse(cur, curLeft, curRight);
        if (isSame(cur, start))
            return false;
        if (curLeft != left || curRight != right) {
            for (int i = 0; i < target.length; i++) {
                start[i] = cur[i];
            }
        }
        return method(cur, curLeft, curRight, target, start);
    }

    private boolean isSame(int[] cur, int[] start) {
        for (int i = 0; i < cur.length; i++) {
            if (cur[i] != start[i])
                return false;
        }
        return true;
    }

    private int[] reverse(int[] array, int left, int right) {
        int[] cur = new int[right - left + 1];
        int index = 0;
        for (int i = 0; i < right - left + 1; i++) {
            if (i % 2 == 1) {
                cur[index++] = array[i + left];
            }
        }
        for (int i = 0; i < right - left + 1; i++) {
            if (i % 2 == 0) {
                cur[index++] = array[i + left];
            }
        }
        for (int i = 0; i < right - left + 1; i++) {
            array[i + left] = cur[i];
        }
        return array;
    }


}

/**
 * 输入：nums = [1,1,1,2,3,4]
 * <p>
 * 输出：[0,1,2,3,3,3]
 * <p>
 * 解释：
 * i = 0，无需操作；
 * i = 1，将 [1,1] 操作成 [1,2] 或 [0,1] 最少 1 次操作；
 * i = 2，将 [1,1,1] 操作成 [1,2,3] 或 [0,1,2]，最少 2 次操作；
 * i = 3，将 [1,1,1,2] 操作成 [1,2,3,4] 或 [0,1,2,3]，最少 3 次操作；
 * i = 4，将 [1,1,1,2,3] 操作成 [-1,0,1,2,3]，最少 3 次操作；
 * i = 5，将 [1,1,1,2,3,4] 操作成 [-1,0,1,2,3,4]，最少 3 次操作；
 * 返回 [0,1,2,3,3,3]。
 */
class SolutionNumsGame {
    public int[] numsGame(int[] nums) {
        int len = nums.length;
        int[] res = new int[nums.length];
        Arrays.fill(res, 0);
        int[] cur = new int[len];
        cur[0] = nums[0];
        for (int i = 1; i < len; i++) {
            cur[i] = cur[i-1]+1;
        }
        for (int i = 1; i < len; i++) {
            res[i] = Math.min(method(nums, i),res[i-1]+Math.abs(cur[i]-nums[i]))%1000000007 ;
            //res[i] = method(nums,i);
            //res[i] = res[i-1]+Math.abs(cur[i]-nums[i]);
        }
        return res;
    }

    private int method(int[] nums, int curIndex) {
        int[] cur = Arrays.copyOf(nums, nums.length);
        int sum = 0;
        for (int i = 0; i <= curIndex; i++) {
            sum += nums[i];
        }
        int mid = sum / (curIndex + 1);
        System.out.println(mid);
        System.out.println(curIndex);
        int index;
        if (curIndex % 2 == 1) {
            index = Math.abs(nums[curIndex / 2] - mid) <= Math.abs(nums[curIndex / 2 + 1] - mid) ? curIndex / 2 : curIndex / 2 + 1;
        } else {
            index = curIndex / 2; // 表示index位置上的数字应该改为mid
        }

        int count = 0;
        count += Math.abs(nums[index] - mid);
        int leftVal = mid - 1;
        int rightVal = mid + 1;
        for (int left = index - 1; left >= 0; left--) {
            count += Math.abs(nums[left] - leftVal);
            leftVal--;
        }
        for (int right = index + 1; right <= curIndex; right++) {
            count += Math.abs(nums[right] - rightVal);
            rightVal++;
        }
        return count;
    }
}
