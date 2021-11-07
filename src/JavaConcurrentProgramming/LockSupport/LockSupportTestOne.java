package JavaConcurrentProgramming.LockSupport;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTestOne {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child thread begin park");
                LockSupport.park();
                System.out.println("chile thread unpark");
            }
        });
        String s = "";
        //thread.start();
        LockSupport.parkNanos(1000);
        //Thread.sleep(1000);
        System.out.println("main thread begin unpark");
        //LockSupport.unpark(thread);
    }
}
