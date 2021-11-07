package JavaConcurrentProgramming;

public class TestOne implements Runnable {
    //共享资源
    private static volatile int i = 0;

    //synchronized 修饰实例方法
    public synchronized void increase() {
        i++;
        //System.out.println(Thread.currentThread().getName()+"is running");
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            increase();

        }
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new TestOne());
        Thread t2 = new Thread(new TestOne());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }

}

