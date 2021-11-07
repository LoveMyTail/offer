package Job.YuanFuDao;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class MainTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Node> list = new ArrayList<>();
        Node[] node = new Node[n];

        for (int i = 0; i < n; i++) {
            int curA = sc.nextInt();
            int curB = sc.nextInt();
            list.add(new Node(curA, curB, new Vector<Integer>()));
            if (curB != 0) {
                list.get(i).adj.add(curB);
            }
        }
        int max_value = list.get(0).a;
        for (int i = 1; i < n; i++) {
            int t1 = max_value + list.get(i).a;
            int t2 = max_value + list.get(i).a;
            for (int j = 0; j < list.get(i).adj.size(); j++) {
                int cur = list.get(i).adj.get(j);
                t2 += list.get(cur).a;
                if (t1 > t2) {
                    if (t1 > max_value)
                        max_value = t1;
                } else {
                    if (t2 > max_value)
                        max_value = t2;
                }
            }

        }
        System.out.println(max_value);
    }
}

class Node {
    int a, b;
    Vector<Integer> adj;
    public Node(int a, int b, Vector<Integer> adj) {
        this.a = a;
        this.b = b;
        this.adj = adj;
    }
}
