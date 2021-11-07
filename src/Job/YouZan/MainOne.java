package Job.YouZan;

import java.util.Scanner;

public class MainOne {
    public static void main(String[] args) {
        SolutionMainOne s = new SolutionMainOne();
        System.out.println(s.sum(3, 5));

    }
}

/**
 * 输入：3,5
 * 输出：37035
 * 说明：3+33+333+3333+33333
 */
class SolutionMainOne {
    public long sum (int num, int itemNum) {
        long res = 0;
        long cur = 0;
        for (int i = 0; i < itemNum; i++) {
            cur = cur*10+num;
            res+=cur;
        }
        return res;

        // write code here
    }
}
