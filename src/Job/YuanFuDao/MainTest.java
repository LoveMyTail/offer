package Job.YuanFuDao;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多线程打印递增数字
 */
public class MainTest implements Runnable{
    private static AtomicInteger num = new AtomicInteger(1);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new MainTest()).start();
        }
    }

    @Override
    public void run() {
        while (true){
            if (num.get()<20){
                num.getAndIncrement();
                System.out.println(Thread.currentThread()+":"+num.get());
            }else{
                break;
            }
        }

    }
}
