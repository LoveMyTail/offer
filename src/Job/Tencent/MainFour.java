package Job.Tencent;

import java.util.Scanner;

public class MainFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(new SolutionMainFour().solve(array, 0, n - 1));
    }
}
class SolutionMainFour{
    public int solve(int[] array,int left,int right){
        if (left>right)
            return 0;

        return 0;
    }
}
