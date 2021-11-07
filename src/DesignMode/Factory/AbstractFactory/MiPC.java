package DesignMode.Factory.AbstractFactory;

public class MiPC implements PC {
    @Override
    public void makePC() {
        System.out.println("建造一部小米电脑");
    }
}
