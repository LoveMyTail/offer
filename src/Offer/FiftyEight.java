package Offer;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 */
public class FiftyEight {
    public static void main(String[] args) {

    }
}

class SolutionFiftyEight {
    public String reverseWords(String s) {
        s = s.trim();
        int right = s.length()-1,left = right;
        StringBuffer stringBuffer = new StringBuffer();
        while (left>=0){
            while (left>=0 && s.charAt(left)!=' ')
                left--;
            stringBuffer.append(s.substring(left+1,right+1)+" ");
            while (left>=0 && s.charAt(left)==' ')
                left--;
            right = left;
        }
        return stringBuffer.toString().trim();
    }
}
