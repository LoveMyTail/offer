package Job.WangYi.SecondTime;

import java.util.HashSet;
import java.util.Scanner;

/*
过山车问题

0 1 2
3 4 5
6
0 3
0 4
1 3
1 4
2 4
2 5
 */
public class MainFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String boy = sc.nextLine();
        String girl = sc.nextLine();
        int n = sc.nextInt();
        int[][] array = new int[n][2];
        for (int i = 0; i < n; i++) {
            array[i][0] = sc.nextInt();
            array[i][1] = sc.nextInt();
        }
        SolutionMainFour s = new SolutionMainFour();
        int i = s.method(array, boy, girl);
        System.out.println(i);
    }
}
// 回溯
class SolutionMainFour {
    public int method(int[][] array, String boy, String girl) {
        HashSet<Integer> boyNum = new HashSet<>();
        HashSet<Integer> girlNum = new HashSet<>();
        String[] boys = boy.split(" ");
        for (String s : boys) {
            boyNum.add(Integer.valueOf(s));
        }
        String[] girls = girl.split(" ");
        for (String s : girls) {
            girlNum.add(Integer.valueOf(s));
        }
        int size = boyNum.size();
        backTracing(boyNum, girlNum, array, 0);
        return size - boyNum.size();
    }

    private void backTracing(HashSet<Integer> boyNum, HashSet<Integer> girlNum, int[][] array, int index) {
        if (boyNum.size() == 0 || girlNum.size() == 0 || index == array.length)
            return;
        if (!boyNum.contains(array[index][0]) || !girlNum.contains(array[index][1])) {
            backTracing(boyNum, girlNum, array, index + 1);
        } else if (boyNum.contains(array[index][0]) && girlNum.contains(array[index][1])) {
            backTracing(boyNum, girlNum, array, index + 1);
            boyNum.remove(array[index][0]);
            girlNum.remove(array[index][1]);
            backTracing(boyNum, girlNum, array, index + 1);
        }
    }
}
