package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 */
public class Problem679 {
    public static void main(String[] args) {

    }
}
// 递归的思路，每次拿出两个数字做相关的操作，然后放回，知道只剩一个数字为止
class SolutionProblem679 {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>(4);
        for (int num : nums) {
            list.add((double) num);
        }
        return solve(list);
    }
    boolean solve(List<Double> nums){
        if(nums.size() == 1){
            return Math.abs(nums.get(0) - 24) <= 0.00001;
        }
        for(int i = 0; i < nums.size(); i++){
            for(int j = i + 1; j < nums.size(); j++){
                List<Double> copy = new ArrayList<>(nums);
                double b = copy.remove(j), a = copy.remove(i);
                boolean valid = false;

                copy.add(a + b);
                valid |= solve(copy);   //  valid = valid || solve(copy)

                copy.set(copy.size() - 1, a - b);
                valid |= solve(copy);

                copy.set(copy.size() - 1, a * b);
                valid |= solve(copy);

                copy.set(copy.size() - 1, a / b);
                valid |= solve(copy);

                copy.set(copy.size() - 1, b - a);
                valid |= solve(copy);

                copy.set(copy.size() - 1, b / a);
                valid |= solve(copy);

                if(valid)
                    return true;
            }
        }
        return false;
    }
}
