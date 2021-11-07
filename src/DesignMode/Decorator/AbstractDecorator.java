package DesignMode.Decorator;

public class AbstractDecorator extends ABatterCake {
    private ABatterCake aBatterCake;

    public AbstractDecorator (ABatterCake aBatterCake) {
        this.aBatterCake = aBatterCake;
    }

    @Override
    protected String getDesc() {
        return this.aBatterCake.getDesc();
    }

    @Override
    protected int cost() {
        return this.aBatterCake.cost();
    }
}
