package Offer;

/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * <p>
 * 请写一个函数，求任意第n位对应的数字。
 */
public class FortyFour {
    public static void main(String[] args) {
        SolutionFortyFour s = new SolutionFortyFour();
        System.out.println(s.findNthDigit(1111));
    }
}

/**
 * 一位数有9个，两位数有90个，三位数有900个，以此类推，先判断第n位属于几位数的区间内
 * 然后再从中寻找所需要的数字
 */
class SolutionFortyFour {
    public int findNthDigit(int n) {
        if (n < 10)
            return n;
        int i = 1;
        while (n > i * Math.pow(10, i - 1) * 9) {
            n -= i * Math.pow(10, i - 1) * 9;
            i++;
        }

        // 此时需要寻找的就是i位数序列的的第n个数
        int num = (int) ((n-1) / i + Math.pow(10, i - 1));
        char[] chars = String.valueOf(num).toCharArray();

        int value = chars[(n - 1) % i] - '0';
        return value;

    }
}
