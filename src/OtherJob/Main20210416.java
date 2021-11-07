package OtherJob;

import java.util.Scanner;

public class Main20210416 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(new SolutionMain20210416().reverse(s));
    }
}

class SolutionMain20210416 {
    public String reverse(String s) {
        System.out.println((char)('a'-32));
        char[] chars = s.toCharArray();
        String reverse = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            reverse += chars[i];
        }
        String replace = reverse.replace("ila", "ali");
        StringBuffer str = new StringBuffer("");
        for (int i = 0; i < replace.length(); ) {
            if (replace.charAt(i) >= 'a' && replace.charAt(i)<='z'){
                if (replace.charAt(i)!='a'){
                    str.append((char)(replace.charAt(i)-32));
                    i++;
                }else {
                    if (replace.charAt(i+1) == 'l' && replace.charAt(i+2) == 'i'){
                        str.append("ali");
                        i+=3;
                    }else{
                        str.append((char)(replace.charAt(i)-32));
                        i++;
                    }
                }
            }else{
                str.append(replace.charAt(i));
                i++;
            }
        }
        return str.toString();
    }
}
