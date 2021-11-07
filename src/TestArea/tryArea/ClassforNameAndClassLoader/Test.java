package TestArea.tryArea.ClassforNameAndClassLoader;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        Class<?> aClass1 = Class.forName("TestArea.tryArea.ClassforNameAndClassLoader.Demo");
//        Object o = aClass1.newInstance();
//        System.out.println(aClass1.getName());

        System.out.println("========================================");

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> aClass2 = classLoader.loadClass("TestArea.tryArea.ClassforNameAndClassLoader.Demo");
        aClass2.newInstance();
        System.out.println(aClass2.getName());
    }
}

class Demo {
    public static String num_static = "静态变量";
    public String num = "变量";

    // 静态代码块
    static {
        System.out.println(num_static);
        System.out.println("静态代码块");
    }

    // 非静态代码块
    {
        System.out.println(num);
        System.out.println("非静态代码块");
    }

    public Demo() {
        System.out.println("构造函数");
    }
}
