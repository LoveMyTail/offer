package Offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 */
public class ThirtyThree {
    public static void main(String[] args) {
        SolutionThirtyThree s = new SolutionThirtyThree();
        System.out.println(s.verifyPostorder(new int[]{1, 6, 3, 2, 5}));
    }
}

/**
 * 分治,对于每一组序列来说，最后一个元素可以将数组分为两个部分，前一部分都比其小，后一部分都比起大
 * 那么只需要找到中间可以区分左子树和右子树的元素即可使用分治法处理
 */
class SolutionThirtyThree {
    public boolean verifyPostorder(int[] postorder) {
        return method(postorder, 0, postorder.length - 1);
    }

    private boolean method(int[] postorder, int i, int j) {
        if (i >= j)
            return true;
        int p = i;
        while (postorder[p] < postorder[j])
            p++;
        int m = p;
        while (postorder[p] > postorder[j])
            p++;
        return p == j && method(postorder, i, m - 1) && method(postorder, m, j - 1);
    }
}
