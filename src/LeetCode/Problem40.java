package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 */
public class Problem40 {
    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        System.out.println(new SolutionProblem40().combinationSum2(candidates, 8));
    }
}
// 注意每个数字只能被使用一次
class SolutionProblem40 {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length==0 || target<0 || candidates == null)
            return list;
        Arrays.sort(candidates);

        method(candidates, target, 0, new ArrayList<>());
        return list;
    }

    private void method(int[] candidates, int target, int i, ArrayList<Integer> cur) {
        if (target < 0)
            return;
        if (target == 0){
            if (!list.contains(new ArrayList<>(cur))){
                list.add(new ArrayList<>(cur));
            }
        }
        if (target>0){
            for (int j = i;j<candidates.length;j++){
                cur.add(candidates[j]);
                method(candidates,target-candidates[j],j+1,cur);
                cur.remove(cur.size()-1);
            }
        }
    }
}
