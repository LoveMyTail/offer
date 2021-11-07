package Job.WangYi.FirstTime;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入T表示有T组测试数据
 * 输入n表示有n个物品
 * 每个物品有对应的价值
 * 将物品分别发给两个人，要求让两个人物品价值相同，请问最少丢掉多少个物品
 * 可以让两人正好拿到价值相同的物品
 */
public class MainThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = sc.nextInt();
            }
            System.out.println(new SolutionMainThree().method(array));
        }
    }
}
class SolutionMainThree{
    public int method(int[] array){
        Arrays.sort(array);
        int num1= 0, num2 = 0;
        for (int i = 0; i < array.length; i++) {
            if (i%2 == 0)
                num1+=array[i];
            else
                num2+=array[i];
        }
        int cur = 0;
        int index = 0;
        if (num1 == num2)
            return 0;
        else{
            while (num1!=num2){
                if (num1>num2){
                    num1-=array[index];
                    cur++;
                }else{
                    num2-=array[index];
                    cur++;
                }
            }

        }
        return cur;
    }

}
