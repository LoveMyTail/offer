package Offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，
 * 则最小的4个数字是1、2、3、4。
 */
public class Forty {
    public static void main(String[] args) {
        SolutionForty s = new SolutionForty();
        int[] numbers = s.getLeastNumbers(new int[]{3,2,1}, 2);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]+" ");
        }
    }
}
class SolutionForty {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] data = new int[k];
        for (int i = 0; i < k; i++) {
            data[i] = arr[i];
        }
        return data;
        /*LinkedHashSet<Integer> set  = new LinkedHashSet<>();
        Arrays.sort(arr);
        for (int i =0 ; i<k;){
            if (set.contains(arr[i])){
                i++;
            }else{
                set.add(arr[i]);
            }
        }
        int[] ints = new int[set.size()];
        int i =0;
        for (Integer integer : set) {
            ints[i] = integer;
            i++;
        }
        return ints;*/
    }
}
