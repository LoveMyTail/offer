package Job.YuanFuDao.Test;

import org.omg.IOP.TAG_RMI_CUSTOM_MAX_STREAM_FORMAT;

public class TwoDMatrixAndGetTarget {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(new SolutionTwoDMatrixAndGetTarget().TwoDMatrixAndGetTarget(array, 13));
    }
}

class SolutionTwoDMatrixAndGetTarget {
    public boolean TwoDMatrixAndGetTarget(int[][] array, int target) {
        if (array.length == 0)
            return false;
        int low = 0, high = array.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid][0] > target)
                high = mid - 1;
            if (array[mid][array[0].length - 1] < target)
                low = mid + 1;
            if (array[mid][0] <= target && array[mid][array[0].length - 1] >= target) {
                low = mid;
                break;
            }
        }
        System.out.println(low);
        int left = 0, right = array[0].length - 1;
        System.out.println(left+" "+right);
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[low][mid] == target)
                return true;
            if (array[low][mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return false;
    }
}
