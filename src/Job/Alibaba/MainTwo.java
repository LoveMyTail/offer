package Job.Alibaba;

import java.util.HashSet;
import java.util.Scanner;

public class MainTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        HashSet<Integer> set = new HashSet<>();
        set.add(7);
        set.add(18);
        set.add(81);
        set.add(29);
        set.add(92);
        set.add(70);
        SolutionMain s = new SolutionMain();
        for (int i = 0; i < T; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int count = s.method(l, r, set);
            System.out.println(count);
        }
    }
}
class SolutionMain{
    public int method(int left, int right, HashSet<Integer> set) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (judge(i, set) == true) {
                count++;
            }
        }
        return count;
    }

    public boolean judge(int num, HashSet<Integer> set) {
        if (set.contains(num))
            return true;
        if (num < 100 && !set.contains(num)) {
            return false;
        }
        char[] chars = String.valueOf(num).toCharArray();
        int cur = 0;
        for (int i = 0; i < chars.length-1; i++) {
            cur = cur*10+Math.abs(chars[i]-chars[i+1]);
        }
        if (set.contains(cur)){
            set.add(num);
            return true;
        }else{
            return false;
        }
    }
}
