package DesignMode.Singleton;

public class SingletonFour {
    private volatile static SingletonFour singleton;

    private SingletonFour(){

    }
    private static SingletonFour getInstance(){
        if (singleton == null){
            synchronized (SingletonFour.class){
                if (singleton == null)
                    singleton = new SingletonFour();
            }
        }
        return singleton;
    }
}
