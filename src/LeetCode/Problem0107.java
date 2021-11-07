package LeetCode;

/**
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 */
public class Problem0107 {
    public static void main(String[] args) {
        SolutionProblem0107 s = new SolutionProblem0107();
        int[][] array = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        s.rotate(array);
        for (int[] ints : array) {
            for (int i : ints) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
class SolutionProblem0107 {
    public void rotate(int[][] matrix) {
        for (int i =0;i<matrix.length;i++){
            for (int j =i;j<matrix.length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i =0;i<matrix.length;i++){
            for (int j =0;j<matrix.length/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-j-1];
                matrix[i][matrix.length-j-1] = temp;
            }
        }
    }
}
