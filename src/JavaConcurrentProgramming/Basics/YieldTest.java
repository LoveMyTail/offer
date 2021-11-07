package JavaConcurrentProgramming.Basics;

public class YieldTest implements Runnable{
    YieldTest(){
        Thread t = new Thread(this);
        t.start();
    }
    public static void main(String[] args) {
        new YieldTest();
        new YieldTest();
        new YieldTest();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if ((i%5)==0){
                System.out.println(Thread.currentThread()+"yield cpu");
                // 当前线程让出CPU执行权，放弃时间片，进行下一轮调度
                //Thread.yield();
            }
        }
        System.out.println(Thread.currentThread()+"is over");
    }
}
