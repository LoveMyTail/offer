package Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 示例 1:
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class FortySix {
    public static void main(String[] args) {
        System.out.println();
    }
}

class SolutionFortySix {
    List<String> list = new ArrayList<>();

    public int translateNum(int num) {
        // 方法一：由后往前，依次递推
/*        if (num <= 9) {
            return 1;
        }
        //xyzcba
        int ba = num % 100;
        if (ba <= 9 || ba >= 26) {
            return translateNum(num / 10);
        } else {
            return translateNum(num / 10) + translateNum(num / 100);
        }*/

        /**
         * 方法二：由前往后，动态规划
         * abcdef的翻译个数等于abcd的翻译个数加上abcde的翻译个数（在ef可翻译的时候）
         * 否则abcdef的翻译个数等于abcde的翻译个数
         */
        String str = String.valueOf(num);
        int a = 1, b = 1;
        for (int i = 2; i <= str.length(); i++) {
            String temp = str.substring(i - 2, i);
            int c = temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;


//        char[] array = String.valueOf(num).toCharArray();
//        StringBuffer stringBuffer = new StringBuffer();
//        method(array, 0, 0, stringBuffer);
//        return list.size();
    }

    private void method(char[] array, int left, int right, StringBuffer stringBuffer) {
        // 如果right到最后一位，那么left有两种情况，要么和right在同一位，要么在right前一位
        if (right == array.length - 1) {
            if (left == right) {
                int num = Integer.parseInt(String.valueOf(array[right]));
                stringBuffer.append(convert(num));
                list.add(stringBuffer.toString());
            } else if (left == right - 1) {
                int num = Integer.parseInt(String.valueOf(array[left] + array[right]));
                stringBuffer.append(convert(num));
                list.add(stringBuffer.toString());
            }
        }

    }

    private char convert(int num) {
        return 0;
    }
}
