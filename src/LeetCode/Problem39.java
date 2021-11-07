package LeetCode;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组candidates和一个目标数target，
 * 找出candidates中所有可以使数字和为target的组合。
 * candidates中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例1:
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 */
public class Problem39 {
    public static void main(String[] args) {
        int[] ints = {2, 3, 6, 7};
        List<List<Integer>> lists = new SolutionProblem39().combinationSum(ints, 7);
        System.out.println(lists);
    }
}

// 回溯
class SolutionProblem39 {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (target == 0)
            return list;
        Arrays.sort(candidates);
        backTracing(candidates, 0, target, new ArrayList<Integer>());
        return list;
    }

    private void backTracing(int[] candidates, int index, int target, List<Integer> cur) {
        if (target < 0)
            return;
        else if (target == 0) {
            list.add(new ArrayList<>(cur));
        } else if (target>0){
            for (int i = index; i < candidates.length; i++) {
                cur.add(candidates[i]);
                backTracing(candidates, i, target-candidates[i], cur);
                cur.remove(cur.size()-1);
            }
        }

    }


}
