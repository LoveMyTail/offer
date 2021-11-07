package Sort;

import java.util.Arrays;

/**
 * 举例：25,84,21,47,15,27,68,35,20
 * 首先选取的临时变量为首个元素为cur=25
 * 然后两个指针分别指向队头和队尾，从队尾先开始向前遍历，如果比临时变量小，则将其与队头所指的元素互换
 * 20,84,21,47,15,27,68,35,20
 * 然后再从队头向后遍历如果比临时变量大，则将其与队头所指的元素互换
 * 最后将临时变量的值赋给左指针
 * 至此，一次遍历就结束了
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {25, 84, 21, 47, 15, 27, 68, 35, 20};
        new myQuickSortSolution().quickSort(array, 0, array.length - 1);
        //quickSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.print(i + "\t");
        }

    }

    // 模板
    private static void quickSort(int[] array, int left, int right) {
        if (left >= right)
            return;
        int curLeft = left;
        int curRight = right;
        int cur = array[curLeft];
        while (curLeft < curRight) {
            while (curLeft < curRight && array[curRight] >= cur) {
                curRight--;
            }
            array[curLeft] = array[curRight];
            while (curLeft < curRight && array[curLeft] <= cur) {
                curLeft++;
            }
            array[curRight] = array[curLeft];
        }
        array[curLeft] = cur;
        quickSort(array, left, curLeft - 1);
        quickSort(array, curRight + 1, right);

    }

}

class myQuickSortSolution {
    public void quickSort(int[] array, int left, int right) {
        if (left >= right)
            return;
        int curLeft = left;
        int curRight = right;
        int curNum = array[curLeft];
        while (curLeft < curRight) {
            while (curLeft < curRight && curNum <= array[curRight]) {
                curRight--;
            }
            array[curLeft] = array[curRight];
            while (curLeft < curRight && curNum >= array[curLeft]) {
                curLeft++;
            }
            array[curRight] = array[curLeft];
        }
        array[curLeft] = curNum;
        quickSort(array, left, curLeft - 1);
        quickSort(array, curRight + 1, right);
    }
}
