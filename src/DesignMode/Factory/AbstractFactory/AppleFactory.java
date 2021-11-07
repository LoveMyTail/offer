package DesignMode.Factory.AbstractFactory;

public class AppleFactory implements AbstractFactory {
    @Override
    public Phone createPhone() {
        return new Iphone();
    }

    @Override
    public PC createPC() {
        return null;
    }
}
