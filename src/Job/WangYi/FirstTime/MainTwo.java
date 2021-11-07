package Job.WangYi.FirstTime;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class MainTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 长度为n的序列S
        int m = sc.nextInt();   // 长度为m的序列T，T为S的子序列
        // T为所求序列的子序列
        ArrayList<Integer> T = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int cur = sc.nextInt();
            T.add(cur);
            set.add(cur);
        }
        if (n == m){
            for (int i = 0; i < T.size(); i++) {
                if (i == T.size()-1)
                    System.out.print(T.get(i));
                else
                    System.out.print(T.get(i)+" ");
            }
        } else{
            ArrayList<Integer> method = new SolutionMainTwo().method(T, set, n);
            for (int i = 0; i < method.size(); i++) {
                if (i == method.size()-1)
                    System.out.print(method.get(i));
                else
                    System.out.print(method.get(i)+" ");
            }
        }

    }
}

class SolutionMainTwo {
    public ArrayList<Integer> method(ArrayList<Integer> T, HashSet<Integer> set, int n) {
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (set.contains(i))
                continue;
            else{
                while (T.get(index)<i){
                    index++;
                    if (index == T.size())
                        break;
                }
                T.add(index,i);
            }
        }
        return T;
    }
}
