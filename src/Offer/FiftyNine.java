package Offer;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 */
public class FiftyNine {
    public static void main(String[] args) {
        MaxQueue obj = new MaxQueue();
        obj.push_back(1);
        obj.push_back(2);
        System.out.println(obj.max_value());
        System.out.println(obj.pop_front());
        System.out.println(obj.max_value());
    }
}

// 暴力法 或 单调队列（保证队列单调，即队列首元素为最大值）
class SolutionFiftyNine {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            if (i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst(); // 删除 deque 中对应的 nums[i-1]
            while (!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast(); // 保持 deque 递减
            deque.addLast(nums[j]);
            if (i >= 0)
                res[i] = deque.peekFirst();  // 记录窗口最大值
        }
        return res;
    }
}

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值
 * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 */
class MaxQueue {
    Deque<Integer> deque = new ArrayDeque<>();
    Queue<Integer> queue = new LinkedList<>();

    public MaxQueue() {
    }

    public int max_value() {
        if (deque.isEmpty())
            return -1;
        return deque.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && value > deque.getLast()) {
            deque.pollLast();
        }
        deque.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty())
            return -1;
        int ans = queue.poll();
        if (ans == deque.peek())
            deque.poll();
        return ans;
    }
}
