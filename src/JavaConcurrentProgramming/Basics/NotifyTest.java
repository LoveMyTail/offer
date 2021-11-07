package JavaConcurrentProgramming.Basics;

public class NotifyTest {
    private static volatile Object resourceA = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println("threadA get resourceA lock");
                    try {
                        System.out.println("threadA begin wait");
                        resourceA.wait();
                        System.out.println("threadA end wait");
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println("threadB get resourceA lock");
                    try {
                        System.out.println("threadB begin wait");
                        resourceA.wait();
                        System.out.println("threadB end wait");
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println("threadC begin notify");
                    resourceA.notifyAll();
                }
            }
        });
        threadA.start();
        threadB.start();
        // 让主线程休眠1s
        Thread.sleep(1000);
        threadC.start();

        /**
         * join()方法用于等待线程执行终止
         */
        threadA.join();
        threadB.join();
        threadC.join();
        System.out.println("main over");
    }
}
