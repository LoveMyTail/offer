package Job.ByteDance;

import java.util.*;

/**
 * 小高最近迷上了玩多米诺骨牌：沿直线将一长串牌摆放起来，推到一个引起连锁反应，非常有趣，现在又n块牌，
 * 每张牌都有各自的高度和宽度（分别记为hi和wi）。小高的摆放规则是，后面的牌的高度和宽度都要大于前面的牌，
 * 请问给n张牌，最多能选多少张组成一个最长牌阵？
 */
public class MainThree {
    public static void main(String[] args) {
        int[] array1 = {6, 3, 4, 5, 7, 8, 9, 1, 0, 2};
        new SolutionMainThree().quickSort(array1, 0, array1.length-1);
        for (int i : array1) {
            System.out.print(i + " ");
        }

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] array = new int[n][2];
        for (int i = 0; i < n; i++) {
            array[i][0] = sc.nextInt();
            array[i][1] = sc.nextInt();
        }
        // 这个解法的关键在于，对于高度 h 相同的数对，要对其宽度 w 进行降序排序。
        // 因为两个高度相同的信封不能相互包含的，逆序排序保证在 h 相同的数对中最多只选取一个。
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o2[1] - o1[1];
                else
                    return o1[0] - o2[0];
            }
        });
        for (int[] ints : array) {
            System.out.println(ints[0] + " " + ints[1]);
        }
        // 动态规划，只需要对w进行读取，然后进行最长子序列的求解即可
        int[] dp = new int[n];
        int[] cur = new int[n];
        for (int i = 0; i < n; i++) {
            cur[i] = array[i][1];
        }
        int num = lengthOfLIS(cur);
        System.out.println(num);

//        dp[0] = 1;
//        int maxAns = 0;
//        for (int i = 1; i < n; i++) {
//            int maxCur = 0;
//            for (int j = 0; j < i; j++) {
//                if (array[i][0] > array[j][0] && array[i][1] > array[j][1]) {
//                    maxCur = Math.max(maxCur, dp[j]);
//                }
//            }
//            dp[i] = maxCur + 1;
//            maxAns = Math.max(maxAns, dp[i]);
//        }
//        System.out.println(maxAns);

    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            // 通过二分法在已经排好序的数组中查找指定的元素，并返回该元素的下标
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}

class SolutionMainThree {
    public void quickSort(int[] array, int left, int right) {
        if (left >= right)
            return;
        int curLeft = left, curRight = right;
        int cur = array[curLeft];
        while (curLeft < curRight) {
            while (curLeft < curRight && array[curRight] >= cur)
                curRight--;
            array[curLeft] = array[curRight];
            while (array[curLeft] <= cur && curLeft < curRight)
                curLeft++;
            array[curRight] = array[curLeft];
        }
        array[curLeft] = cur;
        quickSort(array, left, curLeft - 1);
        quickSort(array, curRight + 1, right);
    }
}
