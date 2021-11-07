package Offer;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 */
public class TwentyNine {
    public static void main(String[] args) {
        int[][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println("x:"+array.length+" y:"+array[0].length);
        SolutionTwentyNine s = new SolutionTwentyNine();
        int[] ints = s.spiralOrder(array);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+" ");
        }
    }
}

class SolutionTwentyNine {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new int[0];
        // m为行号，n为列号
        int m = 0, n = 0, cur = 0;
        // x为行的长度，y为列的长度
        int y = matrix[0].length - 1, x = matrix.length - 1;
        int[] res = new int[(x + 1) * (y + 1)];
        while (true) {
            for (int i = n; i <= y; i++)
                res[cur++] = matrix[m][i];
            if (++m > x)
                break;
            for (int i = m; i <= x; i++)
                res[cur++] = matrix[i][y];
            if (--y < n)
                break;
            for (int i = y; i >= n; i--)
                res[cur++] = matrix[x][i];
            if (--x < m)
                break;
            for (int i = x; i >= m; i--)
                res[cur++] = matrix[i][n];
            if (++n > y)
                break;
        }
        return res;
    }
}
