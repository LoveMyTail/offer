package TestArea.tryArea;

import java.util.Random;

public class RandomNumber {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 60; i++) {
            int num1 = random.nextInt(100);
            int num2 = random.nextInt(100);
            int num3 = random.nextInt(100);
            System.out.print("["+num1+","+num2+","+num3+"],");
        }
    }
}
