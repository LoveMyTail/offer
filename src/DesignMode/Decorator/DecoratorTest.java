package DesignMode.Decorator;

public class DecoratorTest {
    public static void main(String[] args) {
        ABatterCake aBatterCake;
        aBatterCake = new BatterCake();
        aBatterCake = new EggDecorator(aBatterCake);
        aBatterCake = new EggDecorator(aBatterCake);
        aBatterCake = new SausageDecorator(aBatterCake);

        System.out.println(aBatterCake.getDesc()+" 销售价格:"+aBatterCake.cost());
    }
}
