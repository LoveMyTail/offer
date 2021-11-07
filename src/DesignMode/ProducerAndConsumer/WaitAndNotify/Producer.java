package DesignMode.ProducerAndConsumer.WaitAndNotify;

import java.util.Random;

public class Producer implements Runnable{
    private Container container;
    public Producer(Container container){
        this.container = container;
    }
    @Override
    public void run() {
        container.put(new Random().nextInt(100));
    }
}
