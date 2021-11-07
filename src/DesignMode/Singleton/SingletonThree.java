package DesignMode.Singleton;

/**
 * 懒汉式的线程安全版本，但是这种方法效率太低
 * 虽然解决的线程安全问题，但是还会有新的问题：效率低，每个线程想获得类的实例的时候，
 * 执行getInstance（）方法都要进行同步
 */
public class SingletonThree {
    private static SingletonThree singleton;
    private SingletonThree(){

    }
    private static synchronized SingletonThree getInstance(){
        if (singleton == null)
            singleton = new SingletonThree();
        return singleton;
    }


}
