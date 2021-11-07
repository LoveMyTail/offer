package DesignMode.Singleton;

/**
 * 懒汉式
 * 单例实例被延迟加载，即只有在真正使用的时候才会实例化一个对象并交给自己的引用
 * 但是这种方式时线程不安全的，如果在多线程下，一个线程进入了if (singleton == null)判断语句块，
 * 还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例
 */
public class SingletonTwo {
    private static SingletonTwo singleton;

    private SingletonTwo() {
    }

    private SingletonTwo getInstance() {
        if (singleton == null)
            singleton = new SingletonTwo();
        return singleton;
    }

}
