package Offer;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 */
public class Seventeen {
    public static void main(String[] args) {
        SolutionSeventeen s = new SolutionSeventeen();
        int[] ints = s.printNumbers(4);
//        for (int i = 0; i < ints.length; i++) {
//            System.out.print(ints[i]+" ");
//        }
    }
}
class SolutionSeventeen {
    public int[] printNumbers(int n) {
        int num = (int)Math.pow(10,n) - 1;
        System.out.println(num);
        int[] res = new int[num];
        for(int i = 0;i < res.length;i++){
            res[i] = i + 1;
        }
        return res;

    }
}
