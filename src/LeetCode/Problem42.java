package LeetCode;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水
 * （蓝色部分表示雨水）
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Problem42 {
    public static void main(String[] args) {
        System.out.println(new SolutionProblem42Two().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
//
class SolutionProblem42 {
    public int trap(int[] height) {
        if (height == null || height.length==0)
            return 0;
        int num = 0;
        int[] arrayFromLeft = new int[height.length];
        int[] arrayFromRight = new int[height.length];
        arrayFromLeft[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            arrayFromLeft[i] = Math.max(arrayFromLeft[i - 1], height[i]);
        }
        arrayFromRight[height.length - 1] = height[height.length - 1];
        for (int j = height.length - 2; j >= 0; j--) {
            arrayFromRight[j] = Math.max(arrayFromRight[j + 1], height[j]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            num = num + Math.min(arrayFromLeft[i],arrayFromRight[i])-height[i];
        }
        return num;
    }
}
// 双指针法
class SolutionProblem42Two {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max)
                    left_max = height[left];
                else
                    ans += (left_max - height[left]);
                ++left;
            }
            else {
                if (height[right] >= right_max)
                    right_max = height[right];
                else
                    ans += (right_max - height[right]);
                --right;
            }
        }
        return ans;
    }
}
