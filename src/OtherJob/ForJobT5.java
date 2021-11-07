package OtherJob;

import java.util.Arrays;
import java.util.Scanner;

public class ForJobT5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();// m件商品
            int count = sc.nextInt();// m为倍数
            int[] array = new int[m];
            int sum = 0;
            for (int j = 0; j < m; j++) {
                int cur = sc.nextInt();
                sum+=cur;
                array[j]=cur;// 每一件商品的价格
            }
            Arrays.sort(array);
            int index = 0;
            if (sum % count == 0)
                System.out.println(0);
            else{
                while (true){
                    if(sum % count > 0 || (sum-array[index])%count == 0){
                        System.out.println(array[index]);
                        break;
                    }else{
                        sum -= array[index];
                        index++;
                    }
                }
            }
        }
    }
}
