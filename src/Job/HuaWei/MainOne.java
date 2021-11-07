package Job.HuaWei;

import java.util.Arrays;
import java.util.Scanner;

public class MainOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] array = new int[m][n];
        // 要求个位数为7且十位数为奇数的挑选出来
        int[][] ints = new Solution().method(array);
        if (ints.length!=0){
            System.out.print("[");
            for (int i = 0; i < ints.length; i++) {
                if (i == ints.length-1)
                    System.out.print("["+ints[i][0]+","+ints[i][1]+"]]");
                else
                    System.out.print("["+ints[i][0]+","+ints[i][1]+"],");
            }
        }else{
            System.out.println("[]");
        }
    }
}
class Solution{
    public int[][] method(int[][] array){
        if (array.length == 0)
            return new int[0][2];
        // m为行号，n为列号
        int m = 0, n = 0, cur = 0;
        int y = array[0].length - 1, x = array.length - 1;
        int[][] res = new int[array.length*array[0].length][2];
        int count = 1;
        while (true) {
            for (int i = n; i <= y; i++){
                if (judge(count)){
                    System.out.println(count);
                    res[cur][0] = m;
                    res[cur][1] = i;
                    cur++;
                }
                count++;
            }
                //res[cur++] = array[m][i];
            if (++m > x)
                break;
            for (int i = m; i <= x; i++){
                if (judge(count)){
                    System.out.println(count);
                    res[cur][0] = i;
                    res[cur][1] = y;
                    cur++;
                }
                count++;
            }
                //res[cur++] = array[i][y];
            if (--y < n)
                break;
            for (int i = y; i >= n; i--){
                if (judge(count)){
                    System.out.println(count);
                    res[cur][0] = x;
                    res[cur][1] = i;
                    cur++;
                }
                count++;
            }
                //res[cur++] = array[x][i];
            if (--x < m)
                break;
            for (int i = x; i >= m; i--){
                if (judge(count)){
                    System.out.println(count);
                    res[cur][0] = i;
                    res[cur][1] = n;
                    cur++;
                }
                count++;
            }
                //res[cur++] = array[i][n];
            if (++n > y)
                break;
        }
        return Arrays.copyOf(res,cur);
    }

    private boolean judge(int count) {
        if (count<10)
            return false;
        char[] chars = String.valueOf(count).toCharArray();
        if ((chars[chars.length-1]-'0')==7 && (chars[chars.length-2]-'0')%2==1)
            return true;
        else
            return false;

//        if(count>100000){
//            count = count%100000;
//        }
//        if(count>10000){
//            count = count%10000;
//        }
//        if(count>1000){
//            count = count%1000;
//        }
//        if(count>100){
//            count = count%100;
//        }
//        if ((count%10) == 7 && (count/10)%2==1)
//            return true;
//        else
//            return false;
    }
}
