package Offer;

/**
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 *  思路：
 *  例如，求2的32次方，那么当我们已经知道2的16次方的时候，只需要将其再求平方即可
 *  同理，2的16次方也可以向下分解
 *  所以分对于n需要区分奇数与偶数的情况
 *
 */
public class Sixteen {
    public static void main(String[] args) {
        SolutionSixteen s = new SolutionSixteen();
        System.out.println(s.myPow(2.00000, -2147483648));
    }
}

class SolutionSixteen {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        if(n == 1)
            return x;
        if(n == -1)
            return 1 / x;
        double half = myPow(x, n / 2);
        double mod = myPow(x, n % 2);
        return half * half * mod;
    }
}
