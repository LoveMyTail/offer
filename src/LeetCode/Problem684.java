package LeetCode;

/**
 * 在本问题中, 树指的是一个连通且无环的无向图。
 * 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。
 * 附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 * 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v]，满足u < v，表示连接顶点u和v的无向图的边。
 * 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。
 * 答案边[u, v] 应满足相同的格式 u < v。
 * 示例 1：
 * 输入: [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 解释: 给定的无向图为:
 *   1
 *  / \
 * 2 - 3
 * 示例 2：
 * 输入: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * 输出: [1,4]
 * 解释: 给定的无向图为:
 * 5 - 1 - 2
 *     |   |
 *     4 - 3
 * 注意:
 */
public class Problem684 {
    public static void main(String[] args) {

    }
}
// 并查集
class SolutionProblem684 {
    int[] res = new int[2];
    public int[] findRedundantConnection(int[][] edges) {
        if (edges.length == 1)
            return new int[2];
        int len = edges.length+1;;
        int[] father = new int[len];
        for (int i = 0; i < len; i++) {
            father[i] = i;
        }
        for (int[] edge : edges) {
            method(father,edge[0],edge[1]);
        }
        return res;
    }

    //合并两个能连接上的点，father合为最后确定的father
    private void method(int[] father, int from, int to) {
        int xFather = findXFather(father,from);
        int yFather = findXFather(father,to);
        if (xFather!=yFather){
            father[xFather] = yFather;
        }else{
            //在发现两个点的连接已经存在时，就更新缓存，题目要最后一个，遍历到最后一个就是结果
            res[0] = from;
            res[1] = to;
        }
    }

    //路径压缩
    private int findXFather(int[] father, int from) {
        while (father[from]!=from){
            father[from] = father[father[from]];
            from = father[from];
        }
        return from;
    }
}
