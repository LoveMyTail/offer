package DesignMode.Decorator;

public class EggDecorator extends AbstractDecorator {
    public EggDecorator(ABatterCake aBatterCake) {
        super(aBatterCake);
    }

    @Override
    protected String getDesc() {
        return super.getDesc()+"加一个鸡蛋";
    }

    @Override
    protected int cost() {
        return super.cost()+1;
    }
}
