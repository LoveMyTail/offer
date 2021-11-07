package Job.ByteDance.JobInterview;

import java.util.concurrent.atomic.AtomicInteger;

public class TryAgain {
    public static final AtomicInteger num = new AtomicInteger(1);

    public static void main(String[] args) {
        char[] arrayOne = {'1','2','3','4'};
        char[] arrayTwo = {'a','b','c'};
        new Thread(new ThreadOne(arrayOne)).start();
        new Thread(new ThreadTwo(arrayTwo)).start();
    }

    static class ThreadOne implements Runnable{
        char[] arrayOne;
        int index = 0;

        public ThreadOne(char[] arrayOne) {
            this.arrayOne = arrayOne;
        }

        @Override
        public void run() {
            while (true){
                if (num.get() == 1){
                    System.out.println(arrayOne[index]);
                    index++;
                    if (index == arrayOne.length)
                        index = 0;
                    num.set(2);
                }
            }
        }
    }

    static class ThreadTwo implements Runnable{
        char[] arrayTwo;
        int index = 0;

        public ThreadTwo(char[] arrayTwo) {
            this.arrayTwo = arrayTwo;
        }
        @Override
        public void run() {
            while (true){
                if (num.get() == 2){
                    System.out.println(arrayTwo[index]);
                    index++;
                    if (index == arrayTwo.length)
                        index = 0;
                    num.set(1);
                }
            }
        }
    }
}
