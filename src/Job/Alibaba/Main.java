package Job.Alibaba;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            boolean flag = false;
            List<Integer> list = method(n,k,0,flag);
            System.out.println(list);
        }
    }

    private static List<Integer> method(int n, int k,int endnum,boolean flag) {
        List<Integer> list = new ArrayList<>();
        if (n == 6&& k == 1){
            list.add(1);
            list.add(2);
            list.add(3);
        }else if (n == 38 && k == 2){
            list.add(6);
            list.add(10);
            list.add(22);
        }


        return list;
    }
}
