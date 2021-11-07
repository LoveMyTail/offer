package Job.ShangTang;

import java.util.Scanner;

public class MainTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] array = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        System.out.println(new SolutionMainTwo().method(array, n, m));
    }
}

class SolutionMainTwo {
    public int[][] cur = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int r, c;

    public int method(int[][] array, int n, int m) {
        if (n == 0 || m == 0 || array == null)
            return 0;
        r = n;
        c = m;
        int[][] curArray = new int[r][c];
        int ans = 0;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                ans = Math.max(ans, methodDFS(array, i, j, curArray));
            }
        }
        return ans;
    }

    private int methodDFS(int[][] matrix, int row, int column, int[][] curArray) {
        if (curArray[row][column] != 0)
            return curArray[row][column];
        ++curArray[row][column];
        for (int[] ints : cur) {
            int newRow = row + ints[0];
            int newColumn = column + ints[1];
            if (newRow >= 0 && newRow < r && newColumn >= 0 && newColumn < c && matrix[newRow][newColumn] > matrix[row][column]) {
                curArray[row][column] = Math.max(curArray[row][column], methodDFS(matrix, newRow, newColumn, curArray) + 1);
            }
        }
        return curArray[row][column];
    }
}
