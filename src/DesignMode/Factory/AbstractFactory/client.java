package DesignMode.Factory.AbstractFactory;

public class client {
    public static void main(String[] args) {
        MiFactory miFactory = new MiFactory();
        AppleFactory appleFactory = new AppleFactory();
        Phone phone = miFactory.createPhone();
        phone.makePhone();
    }
}
