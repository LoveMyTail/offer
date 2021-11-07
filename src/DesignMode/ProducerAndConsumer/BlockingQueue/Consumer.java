package DesignMode.ProducerAndConsumer.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Consumer implements Runnable{
    private ArrayBlockingQueue<Integer> queue;

    public Consumer(ArrayBlockingQueue<Integer> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
                if (queue.size()==0)
                    System.out.println("=============the queue is empty,the consumer thread is waiting................");
                Integer item = queue.take();
                System.out.println("consumer:"+Thread.currentThread().getName()+"consume"+item+";the size of the queue:"+queue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
