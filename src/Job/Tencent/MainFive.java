package Job.Tencent;

import java.util.Scanner;

public class MainFive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int num = sc.nextInt();
        int[][] cur = new int[num][2];
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            cur[i][0] = sc.nextInt();
            cur[i][1] = sc.nextInt();
        }
        SolutionMainFive s = new SolutionMainFive();
        for (int i = 0; i < num; i++) {
            String temp = str.substring(cur[i][0] - 1, cur[i][1]);
            System.out.println(temp);
            int count = new SolutionMainFive().minCut(temp)+1;
            array[i] = count;
        }
        for (int i : array) {
            System.out.println(i);
        }
    }
}

class SolutionMainFive {
    public boolean isPalin(String str, int begin, int end) {
        while (begin < end) {
            if (str.charAt(begin) != str.charAt(end)) {
                return false;
            } else {
                begin++;
                end--;
            }
        }
        return true;
    }

    public int minCut(String s) {
        if (s.length() <= 1) return 0;
        int[] dp=new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = isPalin(s, 0, i) == true ? 0 : i;
            for (int j = 1; j <= i; j++)
                if (isPalin(s, j, i))
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
        }
        return dp[s.length() - 1];
    }
}
