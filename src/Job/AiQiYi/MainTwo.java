package Job.AiQiYi;

import java.util.HashSet;
import java.util.Scanner;

public class MainTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        boolean b = new SolutionMainTwo().method(str);
        if (b)
            System.out.println("True");
        else
            System.out.println("False");
    }
}
class SolutionMainTwo{
    HashSet<String> set = new HashSet<>();
    int x=0,y=0;
    public boolean method(String str){
        set.add(x+","+y);
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c == 'N')
                y++;
            else if (c == 'S')
                y--;
            else if (c == 'E')
                x++;
            else if (c == 'W')
                x--;

            if (set.contains(x+","+y))
                return true;
            else
                set.add(x+","+y);
        }
        return false;
    }
}
