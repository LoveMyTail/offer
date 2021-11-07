package Job.WangYi.SecondTime;

import java.util.Scanner;

public class MainFourTwo {
    static int[][] line;
    static int[] used;
    static int[] boy;
    static int k, m, n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String boyStr = sc.nextLine();
        String[] boys = boyStr.split(" ");
        m = boys.length;
        String girlStr = sc.nextLine();
        String[] girls = girlStr.split(" ");
        n = girls.length;

        k = sc.nextInt();
        line = new int[1000][1000];
        used = new int[1000];
        boy = new int[1000];
        int sum = 0;
        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            line[a][b] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                used[j] = 0;
            }
            if (find(i)) {
                sum++;
            }
        }
        System.out.println(sum);

    }

    private static boolean find(int x) {
        for (int j = 1; j <= n; j++) {
            if (line[x][j] == 1 && used[j] == 0) {
                used[j] = 1;
                if (boy[j] == 0 || find(boy[j])) {
                    boy[j] = x;
                    return true;
                }
            }
        }
        return false;
    }
}
