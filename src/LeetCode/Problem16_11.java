package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;

public class Problem16_11 {
    public static void main(String[] args) {
        int[] ints = new SolutionProblem16_11().divingBoard(1, 2, 3);
        for (int i : ints) {
            System.out.print(i+" ");
        }
    }
}
class SolutionProblem16_11 {
    int shorter;
    int longer;
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k==0)
            return new int[0];
        //ArrayList<Integer> list = new ArrayList();
        HashSet<Integer> set = new HashSet<>();
        this.shorter = shorter;
        this.longer = longer;
        int length = 0;
        method(set,length,k);
        int[] array = new int[set.size()];
        System.out.println(set);
        Integer[] objects = (Integer[])set.toArray();
        for (int i = 0; i < objects.length; i++) {
            array[i] = objects[i];
        }
        return array;
    }

    public void method(HashSet<Integer> list,int length,int k){
        if(k == 0)
            list.add(length);
        else{
            method(list,length+shorter,k-1);
            method(list,length+longer,k-1);
        }
    }
}
