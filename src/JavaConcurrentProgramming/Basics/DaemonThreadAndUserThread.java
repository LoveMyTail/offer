package JavaConcurrentProgramming.Basics;

public class DaemonThreadAndUserThread {
    // 创建一个守护线程
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;){

                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        System.out.println("main thread is over");
    }
}
