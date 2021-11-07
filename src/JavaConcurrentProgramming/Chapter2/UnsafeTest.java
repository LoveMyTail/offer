package JavaConcurrentProgramming.Chapter2;

import sun.misc.Unsafe;

public class UnsafeTest {
    // 获取Unsafe类的实例
    static final Unsafe unsafe = Unsafe.getUnsafe();

    // 记录变量state在类UnsafeTest中的偏移量
    static final long stateOffset ;

    // 变量
    private volatile long state = 0;

    static {
        try {
            // 获取state变量在类Unsafe中的偏移值
            stateOffset = unsafe.objectFieldOffset(UnsafeTest.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error();
        }
    }

    public static void main(String[] args) {
        // 创建实例，并且设置state值为1
        UnsafeTest test = new UnsafeTest();
        // 比较对象test中偏移量为stateOffset的变量的值是否与0相等，相等则使用1更新
        boolean success = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(success);
    }
}
