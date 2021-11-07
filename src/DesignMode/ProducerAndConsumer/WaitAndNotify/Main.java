package DesignMode.ProducerAndConsumer.WaitAndNotify;

public class Main {
    public static void main(String[] args){
        Container container = new Container();

        Thread producer1 = new Thread(new Producer(container));
        Thread producer2 = new Thread(new Producer(container));
        Thread producer3 = new Thread(new Producer(container));
        Thread producer4 = new Thread(new Producer(container));
        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();

        Thread consumer1 = new Thread(new Consumer(container));
        Thread consumer2 = new Thread(new Consumer(container));
        Thread consumer3 = new Thread(new Consumer(container));
        Thread consumer4 = new Thread(new Consumer(container));
        Thread consumer5 = new Thread(new Consumer(container));
        Thread consumer6 = new Thread(new Consumer(container));
        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
        consumer5.start();
        consumer6.start();
    }
}
