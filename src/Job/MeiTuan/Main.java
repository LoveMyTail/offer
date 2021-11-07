package Job.MeiTuan;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 小团最近对逆序数（将一个数字逐位逆序，例如1234的逆序数为4321）特别感兴趣，但是又觉得普通的逆序数问题有点太乏味了。
 *
 * 于是他想出了一个新的定义：如果一个数的4倍恰好是它的逆序数，那么称这两个数是新定义下的逆序对。
 *
 * 接下来给定一正整数n，问：不超过n的正整数中有多少对新定义下的逆序对？
 *
 *
 *
 * 输入描述
 * 单组输入。
 *
 * 输入一个正整数n，n<1e7。
 *
 * 输出描述
 * 第一行输出在不超过n的前提下有多少对逆序数，接下来每一行输出一对逆序数，以空格分隔。如果有多组逆序数，按照第一个数升序输出。
 *
 * 如果没有一对逆序数则直接输出0即可。
 *
 *
 * 样例输入
 * 10000
 * 样例输出
 * 1
 * 2178 8712
 */
public class Main {
    public static void main(String[] args) {

        HashMap<Integer,String> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i < n; i++) {
            if (judge(i)){
                map.put(i,method(String.valueOf(i)));
            }
        }
        if (map.size()==0)
            System.out.println(0);
        else{
            System.out.println(map.size());
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                System.out.println(entry.getKey()+" "+entry.getValue());
            }
        }

    }
    // 判断n与4n是否是逆序数
    private static boolean judge(int n) {
        BigInteger num = new BigInteger(String.valueOf(n));
        BigInteger cur = num.multiply(new BigInteger("4"));
        if (method(cur.toString()).equals(String.valueOf(n)) )
            return true;
        else
            return false;
    }

    private static String method(String n) {
        StringBuilder sb = new StringBuilder(n);
        String s1 = sb.reverse().toString();
        return s1;
    }
}
//        System.out.println(judge(2178));
//                System.out.println(method(String.valueOf(2178)));
