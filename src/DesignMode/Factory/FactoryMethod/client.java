package DesignMode.Factory.FactoryMethod;

public class client {
    public static void main(String[] args) {
        MiFactory miFactory = new MiFactory();
        AppleFactory appleFactory = new AppleFactory();
        MiPhone miPhone = (MiPhone)miFactory.makePhone();
        IPhone iphone = (IPhone)appleFactory.makePhone();
        miPhone.make();
        iphone.make();
    }
}
