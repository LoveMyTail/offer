package Job.WangYi.SecondTime;

import java.util.Random;
import java.util.Scanner;

public class MainThree {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 用户家个数
        int k = sc.nextInt();   // 电动车剩余还能行驶的路程
        int[] S = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            S[i] = sc.nextInt();
        }
        SolutionMainThree s = new SolutionMainThree();
        int i = s.method(n, k, S);
        System.out.println(i);
    }
}

class SolutionMainThree {
    public int method(int n, int k, int[] S) {
        if (k <= 1)
            return 1;
        int count = 0;



        return count;
        //return k;
    }
}
