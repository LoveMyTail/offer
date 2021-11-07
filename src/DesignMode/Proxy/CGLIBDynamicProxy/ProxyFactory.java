package DesignMode.Proxy.CGLIBDynamicProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 使用cglib需要以上3个jar包
 */

public class ProxyFactory implements MethodInterceptor {

    private Teacher teacher;

    ProxyFactory(Teacher teacher) {
        this.teacher = teacher;
    }

    public Object getProxyInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(teacher.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("---------cglib动态代理开始---------");
        Object returnValue = methodProxy.invoke(teacher, objects);
        System.out.println("---------cglib动态代理结束---------");
        return returnValue;
    }
}
