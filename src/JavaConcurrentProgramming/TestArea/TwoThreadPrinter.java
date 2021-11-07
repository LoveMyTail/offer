package JavaConcurrentProgramming.TestArea;

public class TwoThreadPrinter {
    public static volatile Object lock = new Object();

    public static void main(String[] args) {
        myThread thread = new myThread();
        new Thread(thread,"0").start();
        new Thread(thread,"1").start();
    }

    static class myThread implements Runnable {
        int i = 1;

        @Override
        public void run() {
            synchronized (lock) {
                /**
                 * notify 和wait 的顺序不能错，如果A线程先执行notify方法，B线程在执行wait方法，那么B线程是无法被唤醒的。
                 */
                while (i<100) {
                    if (i % 2 == Integer.parseInt(Thread.currentThread().getName())) {
                        System.out.println(Thread.currentThread().getName()+":"+i++);
                        /** 由于只有两个线程，所以用notify即可，如果是3个或者更多个线程，则需要使用notifyAll
                         *  notify只能唤醒一个等待的线程并使该线程开始执行，如果有多个线程的话，具体取决于操作系统自身的调度
                         */
                        lock.notify();
                    }else{
                        try {
                            // wait是使当前获取到共享对象的线程阻塞，要配合synchronized使用
                            // wait() 需要被try catch包围，以便发生异常中断也可以使wait等待的线程唤醒。
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
