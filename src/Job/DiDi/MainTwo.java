package Job.DiDi;

import jdk.nashorn.internal.ir.CallNode;

import java.math.BigInteger;
import java.util.*;

/**
 * 小明昨晚做了一个梦。在梦里，很多很多斐波那契数连成了一条蛇。突然，最大的那个数变成了蛇头，
 * 把小明一口给吞到肚子里去了。
 * <p>
 * 小明被吓醒了，他赶紧拿笔在纸上面画了一条斐波那契蛇。
 * <p>
 * <p>
 * <p>
 * 这是一个蛇形迂回的斐波那契数列，它是一个n*n的矩阵，在上面的矩阵中n=3。
 * 第1行第1列是最大值，然后按照顺时针的次序数字逐渐变小。
 * <p>
 * 下面是n=4时的情况：
 * <p>
 * <p>
 * <p>
 * 小明希望你能够编写一个程序，输入一个正整数n，然后逐行逐列输出斐波那契蛇形矩阵中的元素。
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 单组输入，输入数据占一行，包含一个正整数n，表示斐波那契蛇形矩阵的大小。(n<10)
 * <p>
 * 输出描述
 * 输出数据占一行，逐行逐列（从第1行开始到第n行，每一行从第1列开始到第n列）
 * 输出斐波那契蛇形矩阵中的元素，每两个数字之间用一个空格隔开。
 * <p>
 * <p>
 * 样例输入
 * 3
 * 样例输出
 * 34 21 13
 * 1 1 8
 * 2 3 5
 */
public class MainTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] ints = new SolutionMainTwo().methodTwo(n);
        if (ints == null)
            System.out.println();
        else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j != n - 1)
                        System.out.print(ints[i][j] + " ");
                    else
                        System.out.print(ints[i][j]);
                }
                System.out.println();
            }
        }
    }
}

class SolutionMainTwo {
    public long[][] methodTwo(int n) {
        if (n < 0 || n >= 10)
            return null;
        if (n == 1) {
            long[][] res = new long[1][1];
            res[0][0] = 1;
            return res;
        }
        long[] array = new long[n * n];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < n * n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        long[][] ans = new long[n][n];
        return method(ans, array, n);
    }

    public static long[][] method(long[][] ans, long[] dp, int n) {
        int index = n * n - 1;
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int num = 1, tar = n * n;
        while (num <= n * n && index >= 0) {
            for (int i = l; i <= r; i++) {
                ans[t][i] = dp[index--];
            }
            t++;
            for (int i = t; i <= b; i++) {
                ans[i][r] = dp[index--];
            }
            r--;
            for (int i = r; i >= l; i--) {
                ans[b][i] = dp[index--];
            }
            b--;
            for (int i = b; i >= t; i--) {
                ans[i][l] = dp[index--];
            }
            l++;
        }
        return ans;
    }

}
