package Job.HuaWei.Interview;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        SolutionTwo s = new SolutionTwo();
        System.out.println(s.getLongestSubString("aaaaa"));
    }
}

class SolutionTwo {
    public int getLongestSubString(String str) {
        if (str == null)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        int max = Integer.MIN_VALUE;
        int left = 0;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                left = Math.max(left, map.get(chars[i]) + 1);
            }
            map.put(chars[i], i);
            max = Math.max(max, i - left+1);
        }
        return max;
    }
}


class SolutionOne {
    public int getNum(int n) {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (judge(i)) {
                list.add(i);
            }
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) - list.get(i) == 2)
                count++;
        }
        return count;
    }

    private boolean judge(int num) {
        boolean flag = true;
        for (int i = 2; i < num / 2 + 1; i++) {
            if (num % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}


class SolutionSum {
    public String sumOfTwoString(String num1, String num2) {
        if (num1.length() == 0)
            return num2;
        if (num2.length() == 0)
            return num1;
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--;
            j--;
        }
        if (carry == 1)
            res.append(1);
        return res.reverse().toString();
    }
}
