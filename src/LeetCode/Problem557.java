package LeetCode;

import java.util.ArrayList;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
public class Problem557 {
    public static void main(String[] args) {
//        ArrayList<String> list  = new ArrayList<>();
//        list.add(Integer.parseInt("1"));
        SolutionProblem557 s = new SolutionProblem557();
        System.out.println(s.reverseWords("Let's take LeetCode contest"));
    }
}
class SolutionProblem557 {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        for (int i = 0; i < strings.length; i++) {
            strings[i] = reverse(strings[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (i == strings.length-1)
                sb.append(strings[i]);
            else{
                sb.append(strings[i]).append(" ");
            }
        }
        return sb.toString();
    }

    private String reverse(String string) {
        StringBuilder builder = new StringBuilder(string);
        return builder.reverse().toString();
    }
}
