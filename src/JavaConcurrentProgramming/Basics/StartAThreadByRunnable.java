package JavaConcurrentProgramming.Basics;

public class StartAThreadByRunnable {
    public static void main(String[] args) {
        RunnableTask task = new RunnableTask();
        new Thread(task).start();
        new Thread(task).start();
    }

    public static class RunnableTask implements Runnable{
        @Override
        public void run() {
            System.out.println("start--------"+System.currentTimeMillis());
        }
    }
}
