package Job.WangYi.SecondTime;

import java.util.Arrays;
import java.util.Scanner;

public class MainTwo {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        SolutionMainTwo s = new SolutionMainTwo();
        int i = s.getLongest(str);
        System.out.println(i);
    }
}

class SolutionMainTwo {
    public int getLongest(String s) {
        int length = s.length();
        //根据每一种元音个数是奇数还是偶数，即六类状态，每一类有0（代表偶数），1（代表奇数），一共可构成2^5=32种状态
        int[] array = new int[1 << 6];
        //初始状态，可通过特殊例子去理解为什么要设成-1
        Arrays.fill(array, -1);
        int max = 0;//最终返回值
        int cur = 0;//表示状态的变量,从0到63
        array[0] = 0;
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ch == 'a')
                cur ^= (1 << 0);//与000001异或
            else if (ch == 'b')
                cur ^= (1 << 1);//与000010异或
            else if (ch == 'c')
                cur ^= (1 << 2);//与000100异或
            else if (ch == 'x')
                cur ^= (1 << 3);//与001000异或
            else if (ch == 'y')
                cur ^= (1 << 4);//与010000异或
            else if (ch == 'z')
                cur ^= (1 << 5);//与100000异或
            if (array[cur] >= 0) {
                max = Math.max(max, i + 1 - array[cur]);
            } else {
                array[cur] = i + 1;
            }
        }
        return max;


//        int max = 0;
//        for (int i = 0; i < length; i++) {
//            for (int j = i; j <= length; j++) {
//                String cur = s.substring(i, j);
//                if (judge(cur)) {
//                    max = Math.max(max, j - i);
//                }
//            }
//        }
//        return max;
    }

    private boolean judge(String cur) {
        boolean a = true, b = true, c = true, x = true, y = true, z = true;
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) == 'a') {
                a = !a;
            }
            if (cur.charAt(i) == 'b') {
                b = !b;
            }
            if (cur.charAt(i) == 'c') {
                c = !c;
            }
            if (cur.charAt(i) == 'x') {
                x = !x;
            }
            if (cur.charAt(i) == 'y') {
                y = !y;
            }
            if (cur.charAt(i) == 'z') {
                z = !z;
            }
        }
        return a && b && c && x && y && z;
    }
}
