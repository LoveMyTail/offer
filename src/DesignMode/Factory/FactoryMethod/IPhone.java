package DesignMode.Factory.FactoryMethod;

public class IPhone implements Phone {
    @Override
    public void make() {
        System.out.println("制造了苹果手机");
    }
}
