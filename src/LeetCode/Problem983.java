package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，
 * 你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 * 火车票有三种不同的销售方式：
 * 一张为期一天的通行证售价为 costs[0] 美元；
 * 一张为期七天的通行证售价为 costs[1] 美元；
 * 一张为期三十天的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，
 * 那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
 */
public class Problem983 {
    public static void main(String[] args) {
        int[] array = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        System.out.println(new SolutionProblem983().mincostTickets(array, costs));
    }
}
// 动态规划
class SolutionProblem983 {
    int[] costs;
    Integer[] memo;
    Set<Integer> set;
    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        memo = new Integer[366];
        set = new HashSet<>();
        for (int day : days) {
            set.add(day);
        }
        return dp(1);
    }

    private int dp(int i) {
        if (i>365)
            return 0;
        if (memo[i] != null)
            return memo[i];
        if (set.contains(i)){
            memo[i] = Math.min(Math.min(dp(i + 1) + costs[0], dp(i + 7) + costs[1]), dp(i + 30) + costs[2]);
        }else{
            memo[i] = dp(i+1);
        }
        return memo[i];
    }
}

/**
 * 输入：days = [1,4,6,7,8,20], costs = [2,7,15]
 * 输出：11
 */
class SolutionProblem983Two {
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length, maxDay = days[len - 1], minDay = days[0];
        int[] dp = new int[maxDay + 31]; // 多扩几天，省得判断 365 的限制
        // 只需看 maxDay -> minDay，此区间外都不需要出门，不会增加费用
        for (int d = maxDay, i = len - 1; d >= minDay; d--) {
            // i 表示 days 的索引
            // 也可提前将所有 days 放入 Set，再通过 set.contains() 判断
            if (d == days[i]) {
                dp[d] = Math.min(dp[d + 1] + costs[0], dp[d + 7] + costs[1]);
                dp[d] = Math.min(dp[d], dp[d + 30] + costs[2]);
                i--; // 别忘了递减一天
            } else
                dp[d] = dp[d + 1]; // 不需要出门
        }
        return dp[minDay]; // 从后向前遍历，返回最前的 minDay
    }
}
