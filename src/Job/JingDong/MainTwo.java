package Job.JingDong;

import java.util.Scanner;

public class MainTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        sc.nextLine();

        int[][] array = new int[n][2 * n - 1];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            //String cur = sc.nextLine();
            s = s.trim();
            //System.out.println(s);
            String[] split = s.split(" ");
            for (int j = 0; j < split.length; j++) {
                array[i][j] = Integer.parseInt(split[j]);
            }

        }
        System.out.println(new SolutionMainTwo().method(array, 0, 0));
    }
}

class SolutionMainTwo {
    public int method(int[][] array, int x, int y) {
        if (x >= array.length || y >= array[0].length)
            return 0;
        else {
            return array[x][y] + Math.max(method(array, x + 1, y), Math.max(method(array, x + 1, y + 1), method(array, x + 1, y + 2)));
        }
    }
}
