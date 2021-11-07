package DesignMode.Proxy.JDKDynamicProxy;

public class Client {
    public static void main(String[] args) {
        // 创建目标对象
        ITeacherDao target = new TeacherDao();
        // 给目标对象创建代理对象,可以转成IteacherDao
        ITeacherDao instance = (ITeacherDao)new ProxyFactory(target).getProxyInstance();
        // 从此处我们可以看出，class com.sun.proxy.$Proxy0 ， 内存中动态生成了代理对象
        System.out.println(instance.getClass());
        // 通过代理对象，调用目标对象的方法
        instance.teach();

    }
}
