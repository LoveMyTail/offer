package LeetCode;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Problem46 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        SolutionProblem46 s = new SolutionProblem46();
        List<List<Integer>> list = s.permute(nums);
        //System.out.println(list);
        System.out.println(list.size());

    }
}
class SolutionProblem46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(list, cur, nums);
        return list;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> cur, int[] nums) {
        if(cur.size() == nums.length) {
            list.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int num : nums) {
            if(!cur.contains(num)) {
                cur.add(num);
                backtrack(list, cur, nums);
                cur.remove(cur.size() - 1);
            }
        }
    }
}

