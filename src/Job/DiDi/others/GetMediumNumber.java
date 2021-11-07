package Job.DiDi.others;

import java.util.PriorityQueue;

public class GetMediumNumber {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SolutionGetMediumNumber s = new SolutionGetMediumNumber();
        System.out.println(s.GetMediumNumber(array));
    }
}

class SolutionGetMediumNumber {
    public double GetMediumNumber(int[] array) {
        int heapSize = array.length / 2 + 1;
        PriorityQueue<Integer> heap = new PriorityQueue<>(heapSize);
        for (int i = 0; i < heapSize; i++) {
            heap.add(array[i]);
        }
        System.out.println(heap);
        for (int i = heapSize; i < array.length; i++) {
            System.out.println("heap.peek()=" + heap.peek() + ",array[i]=" + array[i]);
            if (heap.peek() < array[i]) {
                heap.poll();
                heap.add(array[i]);
            }
            //System.out.println(heap);
        }
        System.out.println(heap);
        if (array.length % 2 == 1) {
            return (double) heap.peek();
        } else {
            return (double) (heap.poll() + heap.peek()) / 2.0;
        }
    }
}
