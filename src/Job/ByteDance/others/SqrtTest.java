package Job.ByteDance.others;

public class SqrtTest {
    public static void main(String[] args) {
        System.out.println(new SolutionSqrt().sqrt(25, 0.01));
        System.out.println(Math.sqrt(25));
    }
}
// target是输入的数字，x表示精度的大小
class SolutionSqrt {
    public double sqrt(double target, double x) {
        double min, max, mid, newMid;
        min = 1;
        max = target;
        mid = (min + max) / 2;

        do {
            if (mid * mid < target) {
                min = mid;
            } else {
                max = mid;
            }
            newMid = mid;
            mid = (max + min) / 2;
        } while (Math.abs(mid-newMid) > x);

        return mid;
    }
}
