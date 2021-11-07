package LeetCode;

/**
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 */
public class Problem342 {
}
class SolutionProblem342 {
    public boolean isPowerOfFour(int num) {
        if (num == 1)
            return true;
        else if (num>1 && num<4 )
            return false;
        else
            return num>1 && (num&(num-1)) == 0;
    }
}
