package Job.ShangTang;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MainThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
}
class SolutionMainThree {
    /**
     *
     * @param intervals int整型二维数组
     * @return int整型
     */
    public int eraseOverlapIntervals (int[][] intervals) {
        // write code here
        if (intervals.length == 0)
            return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int result = 0;
        int cur = 0;
        int len = intervals.length;
        for (int i = 1; i < len; i++) {
            if (intervals[cur][1]>intervals[i][0]){
                if (intervals[cur][1]>intervals[i][1])
                    cur = i;
                result++;
            }else{
                cur = i;
            }
        }
        return result;
    }
}
