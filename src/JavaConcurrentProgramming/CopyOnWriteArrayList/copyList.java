package JavaConcurrentProgramming.CopyOnWriteArrayList;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class copyList {
    private static volatile CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        arrayList.add("hello");
        arrayList.add("alibaba");
        arrayList.add("welcome");
        arrayList.add("to");
        arrayList.add("hangzhou");

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                // 修改下标为1的元素为baba
                arrayList.set(1,"baba");
                // 删除元素
                arrayList.remove(2);
                arrayList.remove(3);
            }
        });
        // 保证在修改线程启动前获取迭代器
        Iterator<String> itr = arrayList.iterator();
        // 启动线程
        threadOne.start();
        // 等待子线程执行完毕
        threadOne.join();
        // 迭代元素
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
