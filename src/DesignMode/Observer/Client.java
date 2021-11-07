package DesignMode.Observer;

public class Client {
    public static void main(String[] args) {
        // 创建一个主题
        ConcreteSubject subject = new ConcreteSubject();
        // 定义一个观察者
        ConcreteObserver observer = new ConcreteObserver();
        // 观察
        subject.addObserver(observer);
        // 开始活动
        subject.doSomething();
    }
}
