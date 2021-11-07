package OtherJob;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ForJob {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // n个数组
        List<int[]> list = new ArrayList<>();
        for (int i = 0;i<n;i++){
            int length = sc.nextInt();
            int[] cur = new int[length];
            for (int j = 0; j < length; j++) {
                cur[j] = sc.nextInt();
            }
            list.add(cur);
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int P = sc.nextInt();
            ArrayList<Integer> arrayNum = new ArrayList<>();
            for (int j = 0; j < P; j++) {
                arrayNum.add(sc.nextInt()-1);
            }
            int k = sc.nextInt();
            int num = method(list, arrayNum, k);
            System.out.println(num);
        }
    }


    public static int method(List<int[]> list,ArrayList<Integer> arrayNum,int k){
        int[] result = null;
        for (int i = 0; i < arrayNum.size(); i++) {
            if (i == 0){
                result = list.get(arrayNum.get(i));
            }else{
                result = concatAll(result,list.get(arrayNum.get(i)));
            }
        }
        Arrays.sort(result);
        return result[k-1];
    }

    // 合并数组
    public static int[] concatAll(int[] first, int[]... rest) {
        int totalLength = first.length;
        for (int[] array : rest) {
            totalLength += array.length;
        }
        int[] result = Arrays.copyOf(first, totalLength);
        int offset = first.length;
        for (int[] array : rest) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }
        return result;
    }
}
