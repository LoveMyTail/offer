package Job.JingDong;

import java.util.Scanner;

public class MainOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SolutionMainOne s = new SolutionMainOne();
        s.init();
        System.out.println(s.nums[n-1]);
    }
}
class SolutionMainOne{
    long[] nums = new long[1000000];
    int cnt = 0;
    public boolean only_235(long n){
        while (n>0){
            if (n%10 !=2 && n%10!=5 && n%10!=3){
                return false;
            }
            n/=10;
        }
        return true;
    }

    public void init(){
        for (int i = 2; i < 1000000; i++) {
            if (only_235(i)){
                nums[cnt++] = i;
            }
        }
    }
}
