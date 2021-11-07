package Job.YuanFuDao.Test;

/**
 * 部分翻转有序数组的查找：原数组有序：1,2,3,4,5,6,7,8；
 * 将前面一部分翻转：4,5,6,7,8,1,2,3，如何查找
 */
public class SearchNumberInReverserArray {
    public static void main(String[] args) {
        int[] array = {4, 5, 6, 7, 8, 1, 2, 3};
        System.out.println(new SolutionSNIRA().searchNumberInReverserArray(array, 6));
    }
}

class SolutionSNIRA {
    public int searchNumberInReverserArray(int[] array, int num) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == num)
                return mid;
            if (array[left] < array[mid])
                if (array[left] <= num && num < array[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            else {
                if (array[mid] < num && num <= array[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }

        }
        return left;
    }
}
