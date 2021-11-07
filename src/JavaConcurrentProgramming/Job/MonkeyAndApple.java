package JavaConcurrentProgramming.Job;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 共计9个苹果，有2只猴子，一个猴子每次拿2个苹果，一个猴子每次拿3个苹果，
 * 如果剩余的苹果不够猴子每次拿的数量，则2只猴子停止拿苹果，
 * 请用java多线程模拟上面的描述，要求性能尽可能高效
 */
public class MonkeyAndApple implements Runnable{
    private static AtomicInteger num = new AtomicInteger(9);
    int curNum;

    public MonkeyAndApple(int curNum) {
        this.curNum = curNum;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new MonkeyAndApple(2));
        threadOne.start();
        Thread threadTwo = new Thread(new MonkeyAndApple(3));
        threadTwo.start();
        threadOne.join();
        threadTwo.join();
    }

    @Override
    public void run() {
        while (num.get()>0){
            if (num.get()>curNum){
                num.set(num.get()-curNum);
                System.out.println(Thread.currentThread()+"拿了"+curNum+"个香蕉");
            }else if(num.get()<curNum){
                System.out.println("当前香蕉不足"+Thread.currentThread()+"停止拿香蕉，香蕉剩余:"+num.get());
                break;
            }else{
                num.set(num.get()-curNum);
                System.out.println(Thread.currentThread()+"拿完了最后的"+curNum+"个香蕉");
            }
        }
    }
}
