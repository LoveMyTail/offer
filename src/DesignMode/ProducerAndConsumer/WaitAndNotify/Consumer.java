package DesignMode.ProducerAndConsumer.WaitAndNotify;

public class Consumer implements Runnable{
    private Container container;
    public Consumer(Container container){
        this.container = container;
    }
    @Override
    public void run() {
        Integer val = container.take();
    }
}
