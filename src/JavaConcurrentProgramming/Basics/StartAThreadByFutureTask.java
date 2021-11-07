package JavaConcurrentProgramming.Basics;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class StartAThreadByFutureTask implements Callable<String> {
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new StartAThreadByFutureTask());
        new Thread(futureTask).start();
        try{
            String s = futureTask.get();
            System.out.println(s);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String call() throws Exception {
        return "hello";
    }
}
