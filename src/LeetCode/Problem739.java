package LeetCode;

/**
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
 * 你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class Problem739 {
    public static void main(String[] args) {

    }
}

// 动态规划 由后向前递推，分情况讨论
class SolutionProblem739 {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0)
            return null;
        if (T.length == 1)
            return new int[]{0};
        int[] array = new int[T.length];
        array[T.length - 1] = 0;
        for (int i = T.length - 2; i >= 0; i--) {
            // j+=array[j]找到比T[j]大的元素的位置，如果比T[i]大，则返回j-i的值，如果array[j]为0
            // 表示T[i]后面没有比其更大的值，否则继续往后找
            for (int j = i + 1; j < T.length; j += array[j]) {
                if (T[i] < T[j]) {
                    array[i] = j - i;
                    break;
                } else if (array[j] == 0) {
                    array[i] = 0;
                    break;
                }
            }
        }
        return null;
    }
}
