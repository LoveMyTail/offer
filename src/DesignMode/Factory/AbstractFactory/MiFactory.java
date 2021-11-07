package DesignMode.Factory.AbstractFactory;

public class MiFactory implements AbstractFactory {
    @Override
    public Phone createPhone() {
        return new MiPhone();
    }

    @Override
    public PC createPC() {
        return new MiPC();
    }
}
