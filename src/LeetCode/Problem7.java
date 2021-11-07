package LeetCode;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 */
public class Problem7 {
    public static void main(String[] args) {
        System.out.println(new SolutionProblem7().reverse(1534236469));
    }
}
class SolutionProblem7 {
    public int reverse(int x) {
        int flag = 1;
        char[] chars = String.valueOf(x).toCharArray();
        int num = 0;
        if (chars[0]=='-'){
            flag = -1;
            for (int i =chars.length-1;i>=1;i--){
                if (num>Integer.MAX_VALUE/10)
                    flag = 0;
                num = num*10+(chars[i]-'0');
            }
        }else{
            for (int i =chars.length-1;i>=0;i--){
                if (num>Integer.MAX_VALUE/10)
                    flag = 0;
                num = num*10+(chars[i]-'0');
            }
        }
        return num*flag;
    }
}
