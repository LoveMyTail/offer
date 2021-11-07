package Sort;

import java.util.Arrays;

/**
 * 堆排序的时间复杂度为O(nlogn),空间复杂度为O(1)
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] array = {3, 2, 6, 4, 8, 7, 9, 1, 0, 5};
        myHeapSort(array);
        System.out.println(Arrays.toString(array));
//        heapSort(array);
//        System.out.println(Arrays.toString(array));

    }

    private static void myHeapSort(int[] array) {
        // 从第一个非叶子节点开始调整
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            method(array, i, array.length);
        }
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            method(array, 0, i);
        }
    }

    private static void method(int[] array, int i, int length) {
        int temp = array[i];
        for (int k = 2 * i + 1; k < length; k = 2 * i + 1) {
            if (k + 1 < length && array[k] < array[k + 1]) {
                k++;
            }
            if (temp < array[k]) {
                array[i] = array[k];
                i = k;
            } else
                break;
        }
        array[i] = temp;
    }


    private static void heapSort(int[] array) {
        // 首先构建大顶堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            // 从第一个非叶子节点从下至上，从右至左调整结构
            adjustHeap(array, i, array.length);
        }
        System.out.println(Arrays.toString(array));
        // 调整堆结构+交换堆顶元素与末尾元素
        for (int j = array.length - 1; j > 0; j--) {
            System.out.println("这是第" + (array.length - 1 - j) + "次调整");
            //将堆顶元素与末尾元素进行交换
            swap(array, 0, j);
            System.out.println(Arrays.toString(array));
            //重新对堆进行调整
            adjustHeap(array, 0, j);
            System.out.println(Arrays.toString(array));
        }

    }

    private static void adjustHeap(int[] array, int i, int length) {
        //先取出当前元素i
        int temp = array[i];
        //从i结点的左子结点开始，也就是2i+1处开始
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //如果左子结点小于右子结点，k指向右子结点
            if (k + 1 < length && array[k] < array[k + 1]) {
                k++;
            }
            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if (array[k] > temp) {
                array[i] = array[k];
                i = k;
            } else {
                break;
            }
        }
        //将temp值放到最终的位置
        array[i] = temp;
    }


    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
