package Offer;

public class Ten {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int fib = solution.fib(7);
        System.out.println(fib);
    }
}

class Solution {
    public int fib(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = (array[i - 1] + array[i - 2]) % 1000000007;

        }
        return array[n];
    }
}
