package Job.Tencent;

import java.util.Scanner;


public class MainThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SolutionMainThree s = new SolutionMainThree();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            System.out.println(s.method(num));
        }
    }
}

class SolutionMainThree {
    public int method(int num) {
        if (num<10)
            return num;
        int left = 10, right = num-10;
        int max = 0;
        while (left <= right) {
            max = Math.max(max, value(left) + value(right));
            left++;
            right--;
        }
        return max;
    }

    public int value(int num) {
        if (num < 10)
            return num;
        int cur = 0;
        while (num > 0) {
            cur += num % 10;
            num = num / 10;
        }
        return cur;
    }
}
