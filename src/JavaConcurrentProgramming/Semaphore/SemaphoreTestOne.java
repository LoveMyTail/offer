package JavaConcurrentProgramming.Semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTestOne {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            new Thread(){
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName()+"正在执行");
                        sleep(2000);
                        System.out.println(Thread.currentThread().getName()+"执行完毕");
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
