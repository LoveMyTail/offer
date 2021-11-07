package Job.YuanFuDao;

import java.util.Scanner;

/**
 * 小猿在网上买了N节课，每节课有开始时间S和结束时间E，这些课之间彼此的时间可能有冲突，小猿可以一心多用，
 * 那么小猿最少需要一心几用呢？
 *
 * 输入N表示买了几节课，接下来输入N行数据，每行输入S和E，表示开始时间和结束时间，
 * 返回同一时间段内最少需要同时上几门课。
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] array = new int[num][2];
        for (int i = 0; i < num; i++) {
            array[i][0] = sc.nextInt();
            array[i][1] = sc.nextInt();
        }
        System.out.println(new Solution().Smallest(array));
    }
}

class Solution {
    public int Smallest(int[][] array) {
        if (array.length == 1)
            return 1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i][0] < min)
                min = array[i][0];
            if (array[i][1] > max)
                max = array[i][1];
        }
        int ans = 0;
        for (int start = min, end = min + 1; start < max; start++,end++) {
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j][0] <= start && array[j][1] >= end)
                    count++;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
