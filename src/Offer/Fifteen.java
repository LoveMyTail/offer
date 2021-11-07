package Offer;

/**
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
 * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 */
public class Fifteen {
    public static void main(String[] args) {
        SolutionFifteen s = new SolutionFifteen();
        System.out.println(s.hammingWeight(00000000000000000000000000001011));
    }
}

class SolutionFifteen {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int num = 0;
        while (n != 0) {
            num += n & 1;
            n >>>= 1;
        }
        return num;
    }
}
