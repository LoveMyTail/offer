package DesignMode.Factory.FactoryMethod;

public class MiFactory implements AbstractFactory {
    @Override
    public Phone makePhone() {
        return new MiPhone();
    }
}
