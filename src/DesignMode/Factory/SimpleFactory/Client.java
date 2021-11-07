package DesignMode.Factory.SimpleFactory;

/**
 * 简单工厂模式存在一系列问题：
 *
 * - 工厂类集中了所有实例的创建逻辑，一旦这个工厂不能工作，整个系统都会受到影响
 * - 违背“开放-关闭原则”，一旦添加新产品就不得不修改工厂类的逻辑，这样就会造成工厂逻辑过于复杂
 * - 简单工厂模式由于使用了静态工厂方法，静态方法不能被继承或者重写，会造成工厂角色无法形成基于继承的等级结构
 */
public class Client {
    public static void main(String[] args) {
        PhoneFactory factory = new PhoneFactory();
        MiPhone miPhone = (MiPhone)factory.makePhone("MiPhone");
        miPhone.make();
    }
}
