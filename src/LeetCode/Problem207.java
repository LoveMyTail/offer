package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，
 * 我们用一个匹配来表示他们：[0,1]
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * 示例 1:
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 */
public class Problem207 {
    public static void main(String[] args) {

    }
}
// 拓扑排序 广度优先方法
class SolutionProblem207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        // 遍历数组，cp[0]表示入度，cp[1]表示出度
        for(int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        // 遍历入度的数组，如果入度数组为0，则将其放入队列
        for(int i = 0; i < numCourses; i++)
            if(indegrees[i] == 0)
                queue.add(i);
        // 队列中放的都是入度为0的节点，也就是只有他们指向其他节点，其他节点不指向他们
        while(!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for(int cur : adjacency.get(pre))
                if(--indegrees[cur] == 0)
                    queue.add(cur);
        }
        return numCourses == 0;
    }
}
// 拓扑排序，方法二，深度优先DFS
class SolutionProblem207Two {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        // 定义一个标志列表，用于判断每个节点i（课程）的状态，0表示未被访问，1表示已经被当前节点启动的ODF访问，
        // -1表示已经被其他节点启动的DFS访问
        int[] flags = new int[numCourses];
        for(int[] cp : prerequisites)
            // 表示cp[1]这个节点都指向了哪些节点
            adjacency.get(cp[1]).add(cp[0]);
        for(int i = 0; i < numCourses; i++)
            if(!dfs(adjacency, flags, i))
                return false;
        return true;
    }
    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if(flags[i] == 1)
            return false;
        if(flags[i] == -1)
            return true;
        flags[i] = 1;
        for(Integer j : adjacency.get(i))
            if(!dfs(adjacency, flags, j))
                return false;
        flags[i] = -1;
        return true;
    }
}
