package Job.WangYi.FirstTime;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MainFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        MyObject[] myObjects = new MyObject[m];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            myObjects[i] = new MyObject(u, v, w);
        }
        int i = new SolutionMainFour().Kruskal(myObjects, m, n);
        System.out.println(i);
    }
}

class SolutionMainFour {
    int mnx = 1001;
    int mxe = 1000001;

    public int Kruskal(MyObject[] myObjects, int m, int n) {
        int[] fa = new int[mnx];
        int ret = 100000;
        Arrays.sort(myObjects, new Comparator<MyObject>() {
            @Override
            public int compare(MyObject o1, MyObject o2) {
                return o1.w - o2.w;
            }
        });
        for (MyObject myObject : myObjects) {
            System.out.println(myObject);
        }
        for (int k = 1; k <= m; k++) {
            for (int i = 1; i <= n; i++) {
                fa[i] = i;
            }
            int min = 0, max = -100000;
            min = myObjects[k].w;
            int t = 0;
            for (int i = k; i <= m; i++) {
                int u = myObjects[i].u, v = myObjects[i].v, w = myObjects[i].w;
                u = find(u, fa);
                v = find(v, fa);
                if (n != v) {
                    fa[u] = v;
                    if (myObjects[i].w > max)
                        max = myObjects[i].w;
                    t++;
                }
            }
            if (t == n - 1) {
                if (max - min < ret)
                    ret = max - min;
            }
        }
        return ret;

    }

    private int find(int u, int[] fa) {
        if (fa[u] != u)
            fa[u] = find(u, fa);
        return fa[u];
    }


}

class MyObject implements Comparable {
    int u;
    int v;
    int w;

    public MyObject(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "u=" + u +
                ", v=" + v +
                ", w=" + w +
                '}';
    }
}
