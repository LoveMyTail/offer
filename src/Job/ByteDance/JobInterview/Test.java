package Job.ByteDance.JobInterview;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 有两个数组，任意长度。 有两个线程分别读取数组a和数组b，线程1循环打印数组a中的数字，
 * 线程2循环打印数组b中的数，要求交叉，要求第一个数组先输出。
 * <p>
 * int a[n] = {1,2,3,4} int b[m] = {'a', 'b', 'c'}
 * 以上述a、b数组为例，最终打印的结果类似于下面：
 * <p>
 * 1a2b3c4a1b2c3a4b1c...
 */
public class Test {
    //public static volatile Object lock = new Object();
    public static volatile int i = 1;
    public static final AtomicInteger num = new AtomicInteger(1);
    public static void main(String[] args) {
        int[] arrayOne = {1, 1, 1, 1, 1, 1, 1};
        int[] arrayTwo = {2, 2, 2, 2, 2, 2, 2};
        myThreadOne myThreadOne = new myThreadOne(arrayOne);
        myThreadTwo myThreadTwo = new myThreadTwo(arrayTwo);
        new Thread(myThreadOne, "1").start();
        new Thread(myThreadTwo, "0").start();
//        new Thread(()->{
//            for (int one : arrayOne) {
//                while (num.get()!=1){}
//                System.out.println(one);
//                num.set(2);
//            }
//        }).start();
//        new Thread(()->{
//            for (int one : arrayTwo) {
//                while (num.get()!=2){}
//                System.out.println(one);
//                num.set(1);
//            }
//        }).start();
    }

    static class myThreadOne implements Runnable {
        int[] arrayOne;
        int indexOne = 0;

        public myThreadOne(int[] arrayOne) {
            this.arrayOne = arrayOne;
        }

        @Override
        public void run() {
            while (indexOne < arrayOne.length) {
                if (i % 2 == Integer.parseInt(Thread.currentThread().getName())) {
                    System.out.println(arrayOne[indexOne++ == arrayOne.length?0:indexOne++]);

                    i++;
                }
            }
        }
    }

    static class myThreadTwo implements Runnable {
        int[] arrayTwo;
        int indexTwo = 0;

        public myThreadTwo(int[] arrayTwo) {
            this.arrayTwo = arrayTwo;
        }

        @Override
        public void run() {
            while (indexTwo < arrayTwo.length) {
                if (i % 2 == Integer.parseInt(Thread.currentThread().getName())) {
                    System.out.println(arrayTwo[indexTwo++]);
                    i++;
                }
            }

        }
    }
}
