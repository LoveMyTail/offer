package Offer;

/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 */
public class FortyThree {
    public static void main(String[] args) {
        SolutionFortyThree s = new SolutionFortyThree();
        System.out.println(s.countDigitOne(12));
    }
}
class SolutionFortyThree {
    // 方法一：暴力解法，将每个数字转换为char[],然后依次判断，时间复杂度O（n²）
    public int countDigitOne1(int n) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            String s = Integer.toUnsignedString(i);
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                if (aChar == '1'){
                    count++;
                }
            }
        }
        return count;
    }

    /** 方法二：递归，将一个数字分为两个部分，然后依次求解，例如将1234分为1000和234
     * high = 1 , pow = 1000 , last = 234
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        return method(n);
    }

    private int method(int n) {
        if (n<=0)
            return 0;
        String s = String.valueOf(n);
        int high = s.charAt(0)-'0';
        int pow = (int)Math.pow(10,s.length()-1);// Math.pow(a,b)求的是a的b次方
        int last = n-high*pow;
        if (high == 1){
            return method(pow-1)+last+method(last)+1;
        }else{
            return pow+high*method(pow-1)+method(last);
        }
    }
}
