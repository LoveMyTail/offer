package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，
 * 并且房间里可能有一些钥匙能使你进入下一个房间。
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j]
 * 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。
 * 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 * 你可以自由地在房间之间来回走动。
 * 如果能进入每个房间返回 true，否则返回 false。
 */
public class Problem841 {
}

/**
 * 可以使用深度优先来遍历整张图、统计可以到达的节点的个数。并利用数组vis标记当前节点是否访问过
 */
class SolutionProblem841 {
    boolean[] visited ;
    int num;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int len = rooms.size();
        num = 0;
        visited = new boolean[len];
        dfs(rooms,0);
        return num == len;
    }

    private void dfs(List<List<Integer>> rooms, int x) {
        visited[x] = true;
        num++;
        for (Integer integer : rooms.get(x)) {
            if (!visited[integer]){
                dfs(rooms,integer);
            }
        }
    }
}

/**
 * 我们也可以使用广度优先搜索的方式遍历整张图，统计可以到达的节点个数，
 * 并利用数组 vis 标记当前节点是否访问过，以防止重复访问。
 */
class SolutionProblem841Two {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size(), num = 0;
        boolean[] vis = new boolean[n];
        Queue<Integer> que = new LinkedList<Integer>();
        vis[0] = true;
        que.offer(0);
        while (!que.isEmpty()) {
            int x = que.poll();
            num++;
            for (int it : rooms.get(x)) {
                if (!vis[it]) {
                    vis[it] = true;
                    que.offer(it);
                }
            }
        }
        return num == n;
    }

}
