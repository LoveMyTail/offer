package LeetCode;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例:
 * 输入:n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Problem77 {
    public static void main(String[] args) {
        SolutionProblem77 s = new SolutionProblem77();
        List<List<Integer>> list = s.combine(4, 2);
        System.out.println(list);
    }
}

class SolutionProblem77 {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (k == 0)
            return list;
        backTracing(n,1,k,new ArrayList<Integer>());
        return list;
    }

    private void backTracing(int n,int index, int k, ArrayList<Integer> cur) {
        if (k == 0){
            list.add(new ArrayList<>(cur));
        }else if (k<0){
            return;
        }else {
            for (int i = index; i <= n; i++) {
                cur.add(i);
                backTracing(n,i+1,k-1,cur);
                cur.remove(cur.size()-1);
            }
        }
    }
}
