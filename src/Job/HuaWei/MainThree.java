package Job.HuaWei;

import java.util.Random;
import java.util.Scanner;

/**
 * 俄罗斯方块问题
 */
public class MainThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.next();
        String second = sc.next();
        char[] frame = first.toCharArray();
        int[] frameInt = new int[frame.length];
        for (int i = 0; i < frame.length; i++) {
            frameInt[i] = frame[i] - '0';
        }
        char[] brick = second.toCharArray();
        int[] brickInt = new int[brick.length];
        for (int i = 0; i < brick.length; i++) {
            brickInt[i] = brick[i] - '0';
        }
        System.out.println(new SolutionMainThree().method(frameInt, brickInt));
    }
}

class SolutionMainThree {
    public int method(int[] frame, int[] brick) {
        int frameLen = frame.length, brickLen = brick.length;
        int res = 1000000;
        for (int i = 0; i < frameLen - brickLen + 1; i++) {
            int maxH = 0, totalMaxH;
            for (int j = 0; j < brickLen; j++) {
                maxH = Math.max(maxH, brick[j] + frame[i + j]);
            }
            totalMaxH = maxH;
            int r = 100000;
            for (int j = 0; j < frameLen; j++) {
                totalMaxH = Math.max(totalMaxH, frame[j]);
                if (j < i)
                    r = Math.min(r, frame[j]);
                else if (j >= (i + brickLen))
                    r = Math.min(r, frame[j]);
                else {
                    int temp1 = frame[j], temp2 = brick[j - i];
                    if (temp1 + temp2 == maxH)
                        r = Math.min(r, maxH);
                    else
                        r = Math.min(r, temp1);
                }
            }
            res = Math.min(res, totalMaxH - r);
        }

        return res;

//        if (brick.length == 0 || frame.length<brick.length) {
//            int max = Integer.MIN_VALUE;
//            for (int i = 0; i < frame.length; i++) {
//                if (frame[i]-'0'>max)
//                    max = frame[i]-'0';
//            }
//            return max;
//        }
//        Random random = new Random();
//        int i = random.nextInt(5);
//        return i;
    }
}
