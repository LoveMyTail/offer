package DesignMode.Decorator.CoffeeTest;

// 具体的Decorator，这里就是调味品
public class Soy extends Decorator {
    public Soy(Drink obj) {
        super(obj);
        setDes("豆浆");
        setPrice(1.5f); // 调味品的价格
    }
}
