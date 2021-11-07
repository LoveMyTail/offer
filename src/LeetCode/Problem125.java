package LeetCode;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 */
public class Problem125 {
    public static void main(String[] args) {

    }
}
class SolutionProblem125 {
    public boolean isPalindrome(String s) {
        String s1 = s.toLowerCase();
        int start = 0;
        int end = s.length()-1;
        char[] chars = s1.toCharArray();
        boolean flag = true;
        while (start<=end){
            if ((chars[start]>='0' && chars[start]<='9') || (chars[start]>='a' && chars[start]<='z' )){
                if ((chars[end]>='0' && chars[end]<='9') || (chars[end]>='a' && chars[end]<='z' )){
                    if (chars[start]==chars[end]){
                        start++;
                        end--;
                    }else{
                        flag=false;
                        break;
                    }
                }else{
                    end--;
                }
            }else {
                start++;
            }
        }
        return flag;
    }
}
