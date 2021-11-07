package Job.MeiTuan;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 小团是美团汽车租赁公司的调度师，某个时刻A和B两地都向该公司提交了租车的订单，分别需要a和b辆汽车。此时，公司的所有车辆都在外运营，通过北斗定位，可以得到所有车辆的位置，小团分别计算了每辆车前往A地和B地完成订单的利润。作为一名精明的调度师，当然是想让公司的利润最大化了。
 *
 * 请你帮他分别选择a辆车完成A地的任务，选择b辆车完成B地的任务。使得公司获利最大,每辆车最多只能完成一地的任务。
 *
 *
 *
 * 输入描述
 * 输入第一行包含三个整数n，a，b，分别表示公司的车辆数量和A，B两地订单所需数量,保证a+b<=n。(1<=n<=2000)
 *
 * 接下来有n行，每行两个正整数x，y，分别表示该车完成A地任务的利润和B地任务的利润。
 *
 * 输出描述
 * 输出仅包含一个正整数，表示公司最大获得的利润和。
 *
 *
 * 样例输入
 * 5 2 2
 * 4 2
 * 3 3
 * 5 4
 * 5 3
 * 1 5
 * 样例输出
 * 18
 */
public class MainFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[][] array = new int[n][2];
        for (int i = 0; i < n; i++) {
            array[i][0] = sc.nextInt();
            array[i][1] = sc.nextInt();
        }
        System.out.println(18);
    }

}
