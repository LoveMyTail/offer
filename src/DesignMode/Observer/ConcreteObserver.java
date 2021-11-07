package DesignMode.Observer;

public class ConcreteObserver implements Observer{
    @Override
    public void update() {
        System.out.println("具体的观察者：收到消息，进行处理");
    }
}
