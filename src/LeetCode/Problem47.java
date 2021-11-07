package LeetCode;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 示例:
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class Problem47 {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        SolutionProblem47 s = new SolutionProblem47();
        List<List<Integer>> list = s.permuteUnique(nums);
        System.out.println(list);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,60, TimeUnit.SECONDS,new ArrayBlockingQueue<>(10));
    }
}

class SolutionProblem47 {

    HashSet<List<Integer>> list = new HashSet<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0)
            return res;
        Arrays.sort(nums);
        boolean[] flag = new boolean[nums.length];
        Arrays.fill(flag, false);
        backTrack(flag, nums, new ArrayList<Integer>(), 0, nums.length);
        for (List<Integer> integerList : list) {
            res.add(new ArrayList<>(integerList));
        }
        return res;
    }

    private void backTrack(boolean[] flag, int[] nums, ArrayList<Integer> cur, int i, int len) {
        if (i == len) {
            list.add(new ArrayList<>(cur));
        } else {
            for (int k = 0; k < nums.length; k++) {
                if (flag[k]) {
                    continue;
                } else {
                    cur.add(nums[k]);
                    flag[k] = true;
                    backTrack(flag, nums, cur, i + 1, len);
                    cur.remove(cur.size() - 1);
                    flag[k] = false;
                }
            }
        }
    }
}
