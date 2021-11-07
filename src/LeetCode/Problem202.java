package LeetCode;

import java.lang.reflect.Proxy;
import java.util.HashSet;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，
 * 那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class Problem202 {
    public static void main(String[] args) {
        SolutionProblem202 s = new SolutionProblem202();
        System.out.println(s.isHappy(19));

    }


}

// 根据运算规则，有两种种情况，第一种是会变为1，也就是该数是快乐数，第二种是会陷入循环中
class SolutionProblem202 {
    HashSet<Integer> set = new HashSet<>();

    public boolean isHappy(int n) {
        return method(n) == 1 ? true : false;
    }

    private int method(int n) {
        int cur = 0;
        while (n != 0) {
            cur += (n % 10) * (n % 10);
            n = n / 10;
        }
        System.out.println(cur);
        if (cur != 1 && set.contains(cur)) {
            return -1;
        } else if (cur == 1) {
            return 1;
        } else {
            set.add(cur);
            return method(cur);
        }
    }

}
