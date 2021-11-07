package Job.AiQiYi;

import java.util.Scanner;

public class MainOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(new SolutionMainOne().CountZero(n));
    }
}

class SolutionMainOne {
    public int CountZero(int n) {
        if (n == 1)
            return 0;
        // 统计有几个2和5
        int countTwo = 0;int countFive = 0;
        for (int i = 2; i <= n; i++) {
            int cur = i;

            while (cur % 2 == 0) {
                cur =  cur/2;
                countTwo++;
            }
            while (cur % 5 == 0) {
                cur =  cur/5;
                countFive++;
            }
        }
        return Math.min(countTwo, countFive);
    }
}
