package JavaConcurrentProgramming.TestArea;

public class TwoThreadExceptionTest extends ThreadGroup {


    public TwoThreadExceptionTest() {
        super("ThreadTest");
    }

    public void uncaughtException(Thread thread, Throwable exception) {
        /**
         * 当线程抛出unckecked异常时,系统会自动调用该函数,但是是在抛出异常的线程内执行
         */
        System.out.println(thread.getId());
        exception.printStackTrace();//example,printStackTrace
    }

    public static void main(String[] args) {
        //传入继承ThreadGroup的类对象
        new Thread(new TwoThreadExceptionTest(), new Runnable() {
            @Override
            public void run() {
                throw new NullPointerException();//只能抛出unchecked异常
            }
        }).start();
    }
}
