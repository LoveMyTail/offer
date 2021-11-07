package LeetCode;

import JavaCollection.FinalTest.FinalTest;

import java.util.*;

/**
 * 你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
 * 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
 * 示例 1:
 * 输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 * 输出: [20,24]
 * 解释:
 * 列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
 * 列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
 * 列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
 */
public class Problem632 {
    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(4);
        cur.add(10);
        cur.add(15);
        cur.add(24);
        cur.add(26);
        List<Integer> curOne = new ArrayList<>();
        curOne.add(0);
        curOne.add(9);
        curOne.add(12);
        curOne.add(20);
        List<Integer> curTwo = new ArrayList<>();
        curTwo.add(5);
        curTwo.add(18);
        curTwo.add(22);
        curTwo.add(30);
        nums.add(cur);
        nums.add(curOne);
        nums.add(curTwo);
        int[] ints = new SolutionProblem632().smallestRange(nums);
        System.out.println(ints[0] + " " + ints[1]);


    }
}

// 该方法复杂度为O（n²），最后一个用例测试不通过，超时
class SolutionProblem632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<List<Integer>>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });
        for (List<Integer> num : nums) {
            queue.offer(num);
        }
        int min = Integer.MAX_VALUE;
        int left = 0, right = 0;
        while (true) {
            int curMin = Integer.MAX_VALUE, curMax = Integer.MIN_VALUE;
            for (List<Integer> curList : queue) {
                if (curList.get(0) < curMin)
                    curMin = curList.get(0);
                if (curList.get(0) > curMax)
                    curMax = curList.get(0);
            }
            if (curMax - curMin < min) {
                min = curMax - curMin;
                left = curMin;
                right = curMax;
            }
            List<Integer> poll = queue.poll();
            poll.remove(0);
            if (poll.size() == 0)
                break;
            else
                queue.offer(poll);
        }
        return new int[]{left, right};
    }
}

// 滑动窗口+hash
class SolutionMethodTwo {
    public int[] smallestRange(List<List<Integer>> nums) {
        int size = nums.size();
        Map<Integer, List<Integer>> indices = new HashMap<Integer, List<Integer>>();
        int xMin = Integer.MAX_VALUE, xMax = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            for (int x : nums.get(i)) {
                List<Integer> list = indices.getOrDefault(x, new ArrayList<Integer>());
                list.add(i);
                indices.put(x, list);
                xMin = Math.min(xMin, x);
                xMax = Math.max(xMax, x);
            }
        }

        int[] freq = new int[size];
        int inside = 0;
        int left = xMin, right = xMin - 1;
        int bestLeft = xMin, bestRight = xMax;

        while (right < xMax) {
            right++;
            if (indices.containsKey(right)) {
                for (int x : indices.get(right)) {
                    freq[x]++;
                    if (freq[x] == 1) {
                        inside++;
                    }
                }
                while (inside == size) {
                    if (right - left < bestRight - bestLeft) {
                        bestLeft = left;
                        bestRight = right;
                    }
                    if (indices.containsKey(left)) {
                        for (int x : indices.get(left)) {
                            freq[x]--;
                            if (freq[x] == 0) {
                                inside--;
                            }
                        }
                    }
                    left++;
                }
            }
        }
        return new int[]{bestLeft, bestRight};
    }
}
