package DesignMode.Observer;

public class ConcreteSubject extends Subject {
    //具体业务
    public void doSomething() {
        //...
        super.notifyObserver();
    }
}
