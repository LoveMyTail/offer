package Offer;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素
 * B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * 示例
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 */
public class SixtySix {
    public static void main(String[] args) {

    }
}

class SolutionSixtySix {
    public int[] constructArr(int[] a) {
        int len = a.length;
        int[] b = new int[len];
        for (int i = 0, cur = 1; i < len; cur *= a[i], i++)
            b[i] = cur;
        for (int i = len - 1, cur = 1; i >= 0; cur *= a[i], i--)
            b[i] *= cur;
        return b;
    }
}
