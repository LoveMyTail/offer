package Offer;

import java.util.Arrays;

/**
 * 找出数组中的重复数字
 *
 * 方法一：先排序，然后依次遍历
 * Arrays.sort()的时间复杂度为O(nlogn)
 *
 * 方法二：利用哈希表，依次与表中数据对比，存在则输出，不存在则存入
 * 但是需要额外的O(n)的空间
 *
 * 方法三：将当前数字与该数字所对应的下标相对比，如果不同的互换位置
 * 尽管代码中存在两重循环，但是每个数字最多交换两次，所以时间复杂度为O(n)，空间复杂度O(1)
 *
 * 方法四：额外利用一个数组，将当前数组中的每一个数字依次放入其中，当冲突时则返回当前数字
 * 时间复杂度O(n)，空间复杂度O(n)
 */
public class Three {
    private static int duplication;
    public static void main(String[] args) {
        int[] numbers = {2, 3, 1, 0, 2, 5, 3};
        int length = numbers.length;
        System.out.println(duplicate(numbers, length));

    }

    static int duplicate(int[] numbers, int length){
        if (numbers == null ||length<=0){
            return -1;
        }
        for (int i = 0; i < length; i++) {
            if (numbers[i]<0 || numbers[i]>length-1){
                return -1;
            }
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i]!=i){
                if (numbers[i]==numbers[numbers[i]]){
                    return numbers[i];
                }
                int temp = numbers[i];
                numbers[i]=numbers[temp];
                numbers[temp]=temp;
            }
        }
        return -1;
    }
}
