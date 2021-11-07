package Job.s360;

import java.util.Scanner;

/**
 * 验证密码复杂性是网站在用户输入初始密码后需要进行的一步操作。现在，小A的网站需要验证密码的复杂性，
 * 小A对一个足够复杂的密码拥有如下要求：
 * 1.要有数字
 * 2.要有大写字母
 * 3.要有小写字母
 * 4.要有特殊字符
 * 5.长度不得小于8
 * 现在给你密码，请你判断这个密码是否足够复杂
 */
public class MainTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SolutionMainTwo s = new SolutionMainTwo();
        while (true){
            String str = sc.next();
            if (s.isValidPassword(str)){
                System.out.println("Ok");
            }else{
                System.out.println("Irregular password");
            }
        }
    }
}

class SolutionMainTwo {
    public boolean isValidPassword(String s) {
        boolean hasNum = false, hasBig = false, hasSmall = false, hasOthers = false;
        int len = s.length();
        if (len < 8) {
            return false;
        } else {
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9')
                    hasNum = true;
                else if (c >= 'A' && c <= 'Z')
                    hasBig = true;
                else if (c >= 'a' && c <= 'z')
                    hasSmall = true;
                else
                    hasOthers = true;
            }
        }
        return hasBig && hasSmall && hasNum && hasOthers;

    }
}
