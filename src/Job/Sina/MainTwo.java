package Job.Sina;

import java.util.Arrays;
import java.util.Scanner;

public class MainTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        SolutionMainTwo s = new SolutionMainTwo();
        System.out.println(s.ifHasSameChar(chars));
    }
}

class SolutionMainTwo {
    public boolean ifHasSameChar(char[] chars) {
        if (chars.length <= 1)
            return true;
        else {
            int t = chars[0];
            boolean flag = true;
            for (int i = 1; i < chars.length; i++) {
                t = t ^ chars[i];
                if (t == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return true;
            else
                return false;
        }
    }

    public boolean method(char[] chars){
        if (chars == null)
            return true;
        for (int i = 0; i < chars.length-1; i++) {
            if (chars[i] == chars[i+1])
                return false;
        }
        return true;
    }
}
