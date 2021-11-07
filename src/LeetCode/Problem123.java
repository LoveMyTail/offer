package LeetCode;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 示例 1:
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，
 * 这笔交易所能获得利润 = 3-0 = 3 。
 * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，
 * 这笔交易所能获得利润 = 4-1 = 3 。
 */
public class Problem123 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        SolutionProblem123 s = new SolutionProblem123();
        System.out.println(s.maxProfit(prices));
    }
}

class SolutionProblem123 {
    public int maxProfit(int[] prices) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> (prices[map.get(o2)]  -prices[o2] ) - (prices[map.get(o1)]  -prices[o1]));
        int i = 0;
        int low = prices[0], high = prices[0];
        int lowIndex = 0,highIndex = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            low = prices[i];
            lowIndex = i;
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            high = prices[i];
            highIndex = i;
            System.out.println(low+" "+high+"  ");
            map.put(lowIndex, highIndex);
            queue.add(lowIndex);
        }
        System.out.println(queue);
        System.out.println(map);
        if (queue.size() >= 2) {
            for (int k = 0; k < 2; k++) {
                Integer poll = queue.poll();
                max +=prices[map.get(poll)]  -prices[poll] ;
            }
        } else if (queue.size() == 1) {
            Integer poll = queue.poll();
            max += prices[map.get(poll)]  -prices[poll];
        } else {
            return 0;
        }

        return max;
    }
}
