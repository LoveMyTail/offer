package JavaConcurrentProgramming.Basics;

public class InterruptAndIsInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ){
                }
            }
        });
        threadOne.start();
        threadOne.interrupt();
        System.out.println("isInterrupted:"+threadOne.isInterrupted());
        System.out.println("isInterrupted:"+threadOne.interrupted());
        System.out.println("isInterrupted:"+Thread.interrupted());
        System.out.println("isInterrupted:"+threadOne.interrupted());
        threadOne.join();
        System.out.println("main thread is over");
    }
}
