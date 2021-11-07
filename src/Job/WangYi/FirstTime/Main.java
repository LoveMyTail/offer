package Job.WangYi.FirstTime;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(new Solution().method(a));
    }
}

class Solution {
    public long method(int[] array) {
        long num = 0;
        for (int i = 0; i < array.length; i++) {
            num += methodNum(array[i]);
        }
        return num;
    }

    private int methodNum(int i) {
        if (i > 3) {
            // 判断该数由多少个2和3组成
            if (i % 2 == 0) {
                return i / 2;
            } else {
                return 1 + (i - 3) / 2;
            }
        } else if (i == 0 || i == 1) {
            return 0;
        } else if (i == 2 || i == 3) {
            return 1;
        }else{
            return 0;
        }
    }
}
