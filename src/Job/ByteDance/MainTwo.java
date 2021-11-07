package Job.ByteDance;


import java.util.*;

/**
 * 给定一个长为n的子串，求最大的交替和
 * 例子：
 * 输入: 5 1 2 3 4 5       输出:5
 * 输入：5 1 -2 3 -4 5     输出:15
 */
public class MainTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(new SolutionMainTwoMethodOne().getSum(array));
    }
}

// 暴力
class SolutionMainTwoMethodOne {
    public int getSum(int[] array) {
        int len = array.length;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int cur = 0;
            for (int j = i; j < array.length; j++) {
                cur += Math.pow(-1, j - i) * array[j];
            }
            count = Math.max(cur, count);
        }
        return count;
    }
}

// 动态规划
class SolutionMainTwoMethodTwo {
    public int getSum(int[] array) {
        int len = array.length;
        int[] dp = new int[len];
        dp[0] = array[0];
        int max = 0;
        for (int i = 1; i < len; i++) {
            // TODO: 2020/8/11  此处动态规划该怎么设计

        }
        return max;
    }
}
