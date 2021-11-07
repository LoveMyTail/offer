package LeetCode;

/**
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class Problem69 {
    public static void main(String[] args) {
        System.out.println(new SolutionProblem69().mySqrt(9));
    }
}

// 二分查找或者牛顿迭代法
class SolutionProblem69 {
    public int mySqrt(int x) {
        int left = 0, right = x;
        int mid = 0;
        while (right-left>1){
            mid = (left+right)/2;
            if (x/mid<mid)
                right = mid;
            else
                left = mid;
        }
        return mid;
    }
}
