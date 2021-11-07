package Offer;

/**
 * 二维数组中的查找
 * 在一个二维数组汇总，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否有含有该整数
 */
public class Four {
    public static void main(String[] args) {
        int[][] array = {{-1, 3}};
        int target = 3;
        // System.out.println(array[0][3]);
        System.out.println(find(array, target));
    }

    private static boolean find(int[][] array, int target) {
        int i = 0;
        int j = array[0].length - 1;
        while (i < array.length && j >= 0) {
            if (array[i][j] == target)
                return true;
            else if (array[i][j] > target)
                j--;
            else if (array[i][j] < target)
                i++;
        }
        return false;
    }
}
