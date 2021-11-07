package LeetCode;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * 示例:
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class Problem96 {
    public static void main(String[] args) {
        System.out.println(new SolutionProblem96().numTrees(3));
    }
}

/**
 * 动态规划
 * 设 G(n) 表示长度为n的序列能构成二叉树的个数； F(i,n) 表示以i为根，长度为n的不同二叉搜索树的个数
 * 则我们可以知道 F(i,n) = G(i-1)*G(n-i);且 G(n) = ∑ F(i,n)
 * 所以有 G(n)= ∑G(i-1)*G(n-i)
 */
class SolutionProblem96 {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
