package JavaConcurrentProgramming.CopyOnWriteArrayList;


import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestOne {
    public static class RunnableTask implements Runnable{
        @Override
        public void run() {
            System.out.println("I am a child Thread");
        }
    }

    public static class CallerTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "hello";
        }
    }

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        new Thread(futureTask).start();
        try{
            String result = futureTask.get();
            System.out.println(result);
        }catch (ExecutionException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
