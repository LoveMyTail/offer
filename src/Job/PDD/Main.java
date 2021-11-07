package Job.PDD;

import java.util.*;
// 通过率94%
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }
        // method(K, N, array);
        int curNum = 0;// 表示回退的次数
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            if (K > array[i]) {
                K -= array[i];
            } else if (K == array[i] && i<N-1) {
                flag = true;
                break;
            } else if (K < array[i]) {
                K = array[i] - K;
                curNum++;
            }
        }
        if (flag) {
            System.out.println("paradox");
        } else {
            System.out.println(K+" "+curNum);
        }

    }
}
