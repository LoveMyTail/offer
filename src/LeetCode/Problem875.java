package LeetCode;

import javax.annotation.Resource;

/**
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。
 * 如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 * 示例 1：
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 * 示例 2：
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 */
public class Problem875 {

    public static void main(String[] args) {
        System.out.println(new SolutionProblem875().minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    }
}

// 二分法，逐步确定合适的速度
class SolutionProblem875 {
    public int minEatingSpeed(int[] piles, int H) {
        int low = 1, high = Integer.MAX_VALUE;
        while (low < high) {
            int mid = low + (high - low) / 2;
            boolean flag = method(piles, H, mid);
            if (!flag)
                low = mid + 1;
            else
                high = mid ;
        }
        return low;
    }

    // 判断其能否以mid的速度在H时间内吃完
    private boolean method(int[] piles, int H, int mid) {
        int time = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] % mid == 0) {
                time += piles[i] / mid;
            } else {
                time += piles[i] / mid + 1;
            }
            //time += piles[i] / mid + 1;
        }
        return time <= H;
    }
}
