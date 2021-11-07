package Job.ShangTang;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class MainOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        System.out.println(new Solution().method(chars));
    }
}

class Solution {
    public int method(char[] chars) {
        if (chars.length < 4)
            return 0;
        int res = 0;
        int numOfG = 0, numOfO = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'G')
                numOfG++;
            if (chars[i] == 'o') {
                if (numOfG > 0)
                    numOfO++;
            }
            if (chars[i] == 'd') {
                if (numOfG > 0 && numOfO >= 2) {
                    res++;
                    numOfG--;
                    numOfO = numOfO - 2;
                }
            }
        }
        return res;
    }
}
