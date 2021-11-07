package LeetCode;

public class Problem108 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        TreeNode treeNode = new SolutionProblem108().sortedArrayToBST(array);
    }
}

class SolutionProblem108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        if (nums.length == 1)
            return new TreeNode(nums[0]);
        int left = 0, right = nums.length - 1;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = method(nums, left, mid - 1);
        node.right = method(nums, mid + 1, right);
        return node;
    }

    public TreeNode method(int[] nums, int left, int right) {
        if (left > right)
            return null;
        if (left == right)
            return new TreeNode(nums[left]);
        int mid = (left + right ) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = method(nums, left, mid - 1);
        node.right = method(nums, mid + 1, right);
        return node;
    }
}
