package Offer;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class Fourteen {
    public static void main(String[] args) {
        SolutionFourteen s = new SolutionFourteen();
        System.out.println(s.cuttingRope(10));
    }
}

/**
 * 考察动态规划，则可容器刻画出动态规划方程 f(n)=max(f(i)*f(n-i))
 * 但是这是从上至下的过程，由于递归会产生很多重复的问题，所以会造成大量不必要的重复计算
 * 所以按照从下至上的顺序计算
 */
class SolutionFourteen {
    public int cuttingRope(int n) {
        if (n < 2)
            return 0;
        else if (n == 2)
            return 1;
        else if (n == 3)
            return 2;
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        array[2] = 2;
        array[3] = 3;
        int max = 0;
        for (int i = 4; i <= n; i++) {
            max = 0;
            for (int j =1;j<=i/2;j++){
                int num = array[j]*array[i-j];
                if (num>max)
                    max = num;
                array[i]=max;
            }
        }
        return max;
    }
}
