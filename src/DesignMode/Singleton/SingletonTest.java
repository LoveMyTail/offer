package DesignMode.Singleton;

public class SingletonTest {
    private volatile static SingletonTest singleton;
    private static int i = 0;

    private SingletonTest(){

    }

    private void add(){
        i++;
    }
    private static SingletonTest getInstance(){
        if (singleton == null){
            synchronized (SingletonTest.class){
                if (singleton == null){
                    i++;
                    singleton = new SingletonTest();

                }

            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        SingletonTest instance = SingletonTest.getInstance();
        System.out.println(instance.i);
        SingletonTest instance1 = SingletonTest.getInstance();
        System.out.println(instance == instance1);
        System.out.println(instance1.i);
    }
}
