package JavaConcurrentProgramming.TestArea;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多线程交替打印数字
 */
public class StrangePrinter {
    private int max;
    // AtomicInteger保证可见性，也可以用volatile
    private AtomicInteger status = new AtomicInteger(1);

    public StrangePrinter(int max) {
        this.max = max;
    }

    public static void main(String[] args) {
        StrangePrinter strangePrinter = new StrangePrinter(100);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(strangePrinter.new MyPrinter("Print1", 0));
        executorService.submit(strangePrinter.new MyPrinter("Print2", 1));
        executorService.shutdown();
    }

    class MyPrinter implements Runnable {
        private String name;
        private int type; // 打印的类型，0：代表打印奇数，1：代表打印偶数

        public MyPrinter(String name, int type) {
            this.name = name;
            this.type = type;
        }

        @Override
        public void run() {
            if (type == 1) {
                while (status.get() <= max) {
                    synchronized (StrangePrinter.class) { // 加锁，保证下面的操作是一个原子操作
                        // 打印偶数
                        if (status.get() <= max && status.get() % 2 == 0) { // 打印偶数
                            System.out.println(name + " - " + status.getAndIncrement());
                        }
                    }
                }
            } else {
                while (status.get() <= max) {
                    synchronized (StrangePrinter.class) { // 加锁
                        // 打印奇数
                        if (status.get() <= max && status.get() % 2 != 0) { // 打印奇数
                            System.out.println(name + " - " + status.getAndIncrement());
                        }
                    }
                }
            }
        }
    }
}
