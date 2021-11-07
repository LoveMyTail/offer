package Offer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序
 * 列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 */
public class ThirtyOne {
    public static void main(String[] args) {

    }
}

/**
 * 模拟压栈的过程，将pushed队列的元素依次压入栈中，当栈顶元素与popped的最前的元素一样的时候
 * 便pop出栈顶元素，否则继续压入元素入栈
 * 当最后检测stack如果不为空，则返回false，否则返回true
 */
class SolutionThirtyOne {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int sizeOne = pushed.length;
        int sizeTwo = popped.length;
        if (sizeOne != sizeTwo)
            return false;
        int j = 0;
        for (int i = 0; i < sizeOne; i++) {
            stack.push(pushed[i]);
            while (!stack.empty() && j < sizeTwo && popped[j] == stack.peek()) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
