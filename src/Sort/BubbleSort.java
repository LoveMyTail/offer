package Sort;

public class BubbleSort {
    public static void main(String[] args) {


        int[] array = {5, 4, 3, 2, 1};
        SolutionBubbleSort s = new SolutionBubbleSort();
        s.bubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }

}

class SolutionBubbleSort {
    public int[] bubbleSort(int[] array) {
        if (array.length <= 1)
            return array;
        for (int i = 0; i < array.length; i++) {
            // 提前退出冒泡循环的标志位,即一次比较中没有交换任何元素，这个数组就已经是有序的了
            boolean flag = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int cur = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = cur;
                    flag = true;
                }
            }
            if (!flag) break;//没有数据交换，数组已经有序，退出排序
        }
        return array;
    }
}
