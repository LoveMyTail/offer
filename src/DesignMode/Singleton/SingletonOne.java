package DesignMode.Singleton;

/**
 * 饿汉式
 */
public class SingletonOne {
    private static SingletonOne singleton = new SingletonOne();

    private SingletonOne() {
    }

    private static SingletonOne getInstance(){
        return singleton;
    }

}
