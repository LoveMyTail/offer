package Job.BiliBili.Test;

import java.util.Scanner;

/**
 * 小A参加了一个n人的活动，每个人都有一个唯一编号i(i>=0 & i<n)，其中m对相互认识，在活动中两个人可以通过互相
 * 都认识的一个人介绍认识。现在问活动结束后，小A最多会认识多少人？
 * 输入描述:
 * 第一行聚会的人数：n（n>=3 & n<10000）；
 * 第二行小A的编号: ai（ai >= 0 & ai < n)；
 * 第三互相认识的数目: m（m>=1 & m )< n(n-1)/2）；
 * 第4到m+3行为互相认识的对，以','分割的编号。
 * 输出描述:
 * 输出小A最多会新认识的多少人？
 * 示例1
 * 输入
 * 7
 * 5
 * 6
 * 1,0
 * 3,1
 * 4,1
 * 5,3
 * 6,1
 * 6,5
 * 输出:3
 */
public class GetFriends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// 聚会的人数
        int ai = sc.nextByte();// 小A的编号
        int m = sc.nextInt();// 相互认识的人数
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        int decrease = 1;
        for (int i = 0; i < m; i++) {
            String[] split = sc.next().split(",");
            int[] nums = new int[2];
            nums[0] = Integer.parseInt(split[0]);
            nums[1] = Integer.parseInt(split[1]);
            combind(a, nums[0], nums[1]);
            if (nums[0] == ai || nums[1] == ai)
                decrease++;
        }
        int ans = 0;
        int aiRoot = find(a,ai);
        for(int i = 0; i < n; i ++) {
            if(find(a, i) == aiRoot) {
                ans ++;
            }
        }
        System.out.println(ans - decrease);
    }

    private static void combind(int[] a, int first, int second) {
        int ff = find(a, first);
        int fs = find(a, second);
        if (ff != fs) {
            a[ff] = fs;
        }
    }

    private static int find(int[] a, int element) {
        if (a[element] != element) {
            return a[element] = find(a, a[element]);
        }
        return element;
    }
}
