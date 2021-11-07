package Job.BiliBili;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(new SolutionThree().GetCoinCount(200));
    }
}

class Solution {
    /**
     * @param arr int整型一维数组
     * @return bool布尔型
     */
    ArrayList<Double> list = new ArrayList<>();

    public boolean Game24Points(int[] arr) {
        // write code here
        for (int i = 0; i < arr.length; i++) {
            list.add((double) arr[i]);
        }
        return method(list);
    }

    private boolean method(ArrayList<Double> list) {
        if (list.size() == 0)
            return false;
        if (list.size() == 1)
            return Math.abs(list.get(0) - 24) < 1e-6;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    ArrayList<Double> cur = new ArrayList<>();
                    for (int k = 0; k < list.size(); k++) {
                        if (k != i && k != j)
                            cur.add(list.get(k));
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && j > i)
                            continue;
                        if (k == 3) {
                            if (list.get(j) != 0)
                                cur.add(list.get(i) / list.get(j));
                            else
                                continue;
                        }
                        if (k == 2)
                            cur.add(list.get(i) - list.get(j));
                        if (k == 1)
                            cur.add(list.get(i) * list.get(j));
                        if (k == 0)
                            cur.add(list.get(i) + list.get(j));
                        if (method(cur))
                            return true;
                        cur.remove(cur.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}

class SolutionThree {
    /**
     *
     * @param N int整型
     * @return int整型
     */
    public int GetCoinCount (int N) {
        // write code here
        int num = 1024-N;
        int count = 0;
        if (num>=64){
            count+=num/64;
            num = num%64;
        }
        if (num>=16){
            count+=num/16;
            num = num%16;
        }
        if (num>=4){
            count+=num/4;
            num = num%4;
        }
        return count+num;
    }
}
