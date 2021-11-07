package Job.MeiTuan;

import java.util.*;

/**
 * 小团是一个旅游爱好者，快要过春节了，他想统计一下，在过去的一年中他进行过几次旅行，于是他打开了美团app的订单记录，记录显示了他的购买车票的记录。记录是按时间顺序给出的，已知一次旅行的线路一定是一个闭环，即起点和终点是同一个地点。因此当每找到一段闭合的行程，即认为完成了一次旅行。数据保证不会出现不在闭环路径中的数据。
 *
 * 请你在小团的购票记录中统计出他全年共进行了多少次旅行？
 *
 *
 *
 * 输入描述
 * 输入第一行包含一个正整数n，表示小团的购票记录数量。(1<=n<=10000)
 *
 * 接下来有n行，每行是两个长度不超过10的仅由小写字母组成的字符串S_a S_b，表示购买了一张从S_a到S_b的车票。
 *
 * 输出描述
 * 输出仅包含一个整数，表示小团的旅行次数。
 *
 *
 * 样例输入
 * 6
 * beijing nanjing
 * nanjing guangzhou
 * guangzhou shanghai
 * shanghai beijing
 * fuzhou beijing
 * beijing fuzhou
 * 样例输出
 * 2
 */
public class MainTwo {
    static HashMap<String,Node> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String a = sc.next();
            String b = sc.next();
            if (!map.containsKey(a)){
                List<Node> neighbors = new ArrayList<>();
                neighbors.add(new Node(b));
                map.put(a,new Node(a,neighbors));
            }else{
                Node node = map.get(a);
                node.neighbors.add(new Node(b));
            }
        }
        int count = 0;
        for (Map.Entry<String, Node> entry : map.entrySet()) {
            if (entry.getKey().equals(method(entry.getKey())) )
                count++;
        }
        System.out.println(count);
    }

    private static String method(String key) {
        Node node = map.get(key);
        if (node.visited == false){
            for (Node neighbor : node.neighbors) {
                if (key.equals(method(neighbor.val))) {
                    neighbor.visited = true;
                    return key;
                }else{
                    neighbor.visited = false;
                }
            }
            return null;
        }else{
            return null;
        }
    }
}
class Node{
    String val;
    List<Node> neighbors;
    boolean visited;

    public Node() {
        visited = false;
    }

    public Node(String val) {
        this.val = val;
        this.visited = false;
    }

    public Node(String val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
        this.visited = false;
    }
}
