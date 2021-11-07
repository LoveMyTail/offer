package Job.AiQiYi;

import java.util.Scanner;
import java.util.Stack;

public class MainThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str =sc.nextLine();
        boolean b = new SolutionMainThree().isValid(str);
        if (b)
            System.out.println("True");
        else
            System.out.println("False");
    }
}
class SolutionMainThree {
    public boolean isValid(String s) {
        if (s.isEmpty())
            return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else if (stack.isEmpty() || c != stack.pop())
                return false;
        }
        return stack.isEmpty();
    }
}
