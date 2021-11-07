package JavaConcurrentProgramming;
// 死锁案例
public class DeadLock {
    public static String obj1 = "obj1";
    public static String obj2 = "obj2";
    public static void main(String[] args) {
        Thread threadOne = new Thread(new ThreadOne());
        Thread threadTwo = new Thread(new ThreadTwo());
        threadOne.start();
        threadTwo.start();

    }
}
class ThreadOne implements Runnable{
    @Override
    public void run() {
        try{
            System.out.println("ThreadOne Running");
            while (true){
                synchronized (DeadLock.obj1){
                    System.out.println("ThreadOne Lock Obj1");
                    Thread.sleep(1000);
                    synchronized (DeadLock.obj2){
                        System.out.println("ThreadOne Lock Obj2");
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
class ThreadTwo implements Runnable{

    @Override
    public void run() {
        try{
            System.out.println("ThreadTwo Running");
            while (true){
                synchronized (DeadLock.obj2){
                    System.out.println("ThreadTwo Lock Obj2");
                    Thread.sleep(1000);
                    synchronized (DeadLock.obj1){
                        System.out.println("ThreadTwo Lock Obj1");
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
