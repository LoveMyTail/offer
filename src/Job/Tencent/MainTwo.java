package Job.Tencent;

import java.util.*;

public class MainTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        System.out.println(new SolutionMainTwo().kthSubString(s, k));
    }
}

class SolutionMainTwo {
    public String kthSubString(String s, int k) {
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        //ArrayList<String> list = new ArrayList<String>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (queue.contains(s.substring(i, j)))
                    continue;
                else{
                    queue.add(s.substring(i, j));
                    if (queue.size()>k){
                        queue.remove();
                    }
                }
            }
        }
        return queue.peek();
    }
}
