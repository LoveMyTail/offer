package LeetCode;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为n 的k个数的组合。组合中只允许含有 1 -9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Problem216 {
    public static void main(String[] args) {
        SolutionProblem216 s = new SolutionProblem216();
        List<List<Integer>> lists = s.combinationSum3(3, 9);
        System.out.println(lists);
    }
}

class SolutionProblem216 {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n < 1 || n > k * 9)
            return list;
        backTracing(k, n,1, new ArrayList<Integer>());

        return list;
    }

    private void backTracing(int k, int n,int curNum, ArrayList<Integer> cur) {
        if (n < 0)
            return;
        else if (n == 0 && k == 0)
            list.add(new ArrayList<>(cur));
        else if (n == 0 && k>0)
            return;
        else{
            for (int i = curNum;i<=9;i++){
                cur.add(i);
                backTracing(k-1,n-i,i+1,cur);
                cur.remove(cur.size()-1);
            }
        }
    }
}
