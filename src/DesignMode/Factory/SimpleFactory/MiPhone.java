package DesignMode.Factory.SimpleFactory;

public class MiPhone implements Phone{
    @Override
    public void make() {
        System.out.println("制造了小米手机");
    }
}
