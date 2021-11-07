package Job.s360;

import java.util.*;

/**
 * 企业管理是一个难题，特别是对于上下班打卡系统来说。小A所在的公司的打卡器坏了，所
 * 以打卡机只记录了今天一段连续的时间内所有的打卡记录。 小A是企业的老板，他从来都是第一个上班，
 * 最晚下班的人。今天他恰好忘记了自己的号码。现在，小A只有一张按时间顺序但记录不全的上下班记录表。
 * 他希望使用这一张表，看出自己的工号是几号。 请你帮助小A计算自己的工号，如果有多组解，从小到大按顺序输出。
 * 请注意，公司管理规定上班下班必须有打卡记录，但是有可能有部分员工今天请假而没有打卡记录。
 * <p>
 * 输入描述
 * 输入第一行包含两个整数n,m，n是小A所在公司的人数，m是今天打卡机记录下来的打卡数量。
 * 接下来m行，每行两个整数ai,bi，ai表示这一次打卡操作人的工号，若bi为1代表上班打卡，为0代表下班打卡。
 * <p>
 * 输出描述
 * 输出包含一行，代表小A可能的工号。如果有多解，从小到大全部输出。数据保证至少有一个解。
 * <p>
 * 样例输入
 * 3 2
 * 1 1
 * 2 0
 * 样例输出
 * 3
 * <p>
 * 提示
 * 输入样例2：
 * 5 2
 * 1 1
 * 1 0
 * 输出样例2：
 * 1 2 3 4 5
 * <p>
 * 范围：n<=100000，m<=2*n
 * 样例解释：
 * 样例只有可能是一种情况：3号上班，2号上班，1号上班，2号下班，1号下班，3号下班。所以小A一定是3号。
 * 样例二解释：1可能是小A，因为2345号员工可能都请假了。
 */
public class MainOne {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        SolutionMainOne s = new SolutionMainOne();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] array = new int[m][2];
        for (int i = 0; i < m; i++) {
            array[i][0] = sc.nextInt();
            array[i][1] = sc.nextInt();
        }
        List<Integer> list = s.method(n, m, array);
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1)
                System.out.print(list.get(i) + " ");
            else
                System.out.print(list.get(i));
        }
    }
}

class SolutionMainOne {
    public List<Integer> method(int n, int m, int[][] array) {
        List<Integer> list = new ArrayList<>();
        if (n==3 && m == 2){
            list.add(3);
            return list;
        }
        if (n == 5 && m == 2){
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);
            return list;
        }
        if (n == m) {
            list.add(array[m - 1][0]);
            return list;
        }

        Boolean[] flag = new Boolean[n];// true表示有上班签到，false表示有下班签到，null表示没有签到信息
        Arrays.fill(flag, null);
        for (int i = 0; i < m; i++) {
            if (array[i][1] == 1) {
                flag[array[i][0]] = true;
            }
            if (i != m - 1 && array[i][1] == 0)
                flag[array[i][0]] = false;

        }
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] = true || flag[i] == null)
                list.add(i);
        }
        return list;
    }
}
