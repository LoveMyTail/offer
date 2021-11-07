package Job.DiDi;

import java.util.*;

/**
 * A+B问题又来了。
 * 设a，b，c是0到9之间的整数（其中a，b，c互不相同），其中abc和acc是两个不同的三位数，
 * 现给定一正整数n，问有多少对abc和acc能满足abc+acc=n（a≠0）？
 * 输入描述
 * 一个正整数n（100<n<2000）。
 * 输出描述
 * 第一行输出有多少对满足要求的数字。
 * 接下来每一行输出一对abc和acc，以空格分隔。如果没有一对abc和acc的话，则直接输出0即可。
 * 如果有多对，请按照abc升序的次序输出。
 * 样例输入
 * 1068
 * 样例输出
 * 1
 * 524 544
 */
public class MainOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Integer> map = new SolutionMainOne().method(n);
        if (map.size() != 0) {
            System.out.println(map.size());
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        } else {
            System.out.println(map.size());
        }

    }
}

class SolutionMainOne {
    HashMap<Integer, Integer> map = new HashMap<>();
    public HashMap<Integer, Integer> method(int n) {
        for (int a = 1; a <= 9; a++) {
            for (int b = 0; b <= 9; b++) {
                for (int c = 0; c <= 9; c++) {
                    if (a * 100 + b * 10 + c + a * 100 + c * 10 + c == n
                            && a != b && a != c && b != c) {
                        map.put(a * 100 + b * 10 + c, a * 100 + c * 10 + c);
                    }
                }
            }
        }
        return map;
    }
}
