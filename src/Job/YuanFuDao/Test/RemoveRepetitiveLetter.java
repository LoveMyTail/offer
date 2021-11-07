package Job.YuanFuDao.Test;

import java.util.Stack;

public class RemoveRepetitiveLetter {
    public static void main(String[] args) {
        System.out.println(new SolutionRemoveRepetitiveLetter().RemoveRepetitiveLetter("ABBA"));
    }
}
class SolutionRemoveRepetitiveLetter{
    public String RemoveRepetitiveLetter(String str){
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        stack.push(chars[0]);
        char cur = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (!stack.isEmpty()){
                if (stack.peek() == chars[i]){
                    cur = chars[i];
                    stack.pop();
                }else if (cur == chars[i]){
                    continue;
                }else {
                    stack.push(chars[i]);
                    cur = chars[i];
                }
            }else{
                if (cur == chars[i])
                    continue;
                else
                    stack.push(chars[i]);
            }

        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
