package DesignMode.Factory.AbstractFactory;

public class MiPhone implements Phone {
    @Override
    public void makePhone() {
        System.out.println("建造一部小米手机");
    }
}
