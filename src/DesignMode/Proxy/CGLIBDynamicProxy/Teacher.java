package DesignMode.Proxy.CGLIBDynamicProxy;

public class Teacher {
    public String teach(){
        System.out.println("--老师正在上课，cglib代理模式正在运行--");
        return "teaching";
    }
}
