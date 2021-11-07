package Offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 */
public class Eleven {
    public static void main(String[] args) {
        int[] numbers = {2,2,2,0,1};
        SolutionEleven s = new SolutionEleven();
        System.out.println(s.minArray(numbers));
    }
}

class SolutionEleven {
    public int minArray(int[] numbers) {
        int start = 0;
        int end = numbers.length-1;
        if (numbers[start]>=numbers[end]){
            while (end>0){
                if (numbers[end]<numbers[end-1])
                    return numbers[end];
            }
        }
        return numbers[0];
    }
}
