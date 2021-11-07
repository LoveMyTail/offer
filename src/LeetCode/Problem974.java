package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 * 示例：
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 */
public class Problem974 {
    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 0, -2, -3, 1};
        System.out.println(new SolutionProblem974().subarraysDivByK(array, 5));
        System.out.println(-1%5);
    }
}

class SolutionProblem974 {
    public int subarraysDivByK(int[] A, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            // 注意Java取模的特殊性，当被除数为负数是取模结果为负值，需要纠正
            int cur = (sum % K + K) % K;
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue() * (entry.getValue() - 1) / 2;
        }
        return count;
    }
}
