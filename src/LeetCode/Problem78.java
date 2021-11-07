package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *  [1],
 *  [2],
 *  [1,2,3],
 *  [1,3],
 *  [2,3],
 *  [1,2],
 *  []
 * ]
 */
public class Problem78 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        SolutionProblem78 s = new SolutionProblem78();
        List<List<Integer>> subsets = s.subsets(nums);
        System.out.println(subsets);
    }
}
class SolutionProblem78 {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0)
            return list;
        backTrack(nums,0,new ArrayList<Integer>());
        return list;
    }

    private void backTrack(int[] nums, int index, ArrayList<Integer> cur) {
        if (index == nums.length){
            list.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[index]);
        backTrack(nums,index+1,cur);
        cur.remove(cur.size()-1);
        backTrack(nums, index+1, cur);
    }
}
