package DesignMode.Factory.AbstractFactory;

public class Iphone implements Phone {
    @Override
    public void makePhone() {
        System.out.println("建造一部苹果手机");
    }
}
