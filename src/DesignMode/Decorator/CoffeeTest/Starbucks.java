package DesignMode.Decorator.CoffeeTest;

public class Starbucks {
    public static void main(String[] args) {
        // 先点一份咖啡
        Drink longBlack = new LongBlack();
        System.out.println("费用1="+longBlack.cost());
        System.out.println("描述1="+longBlack.getDes());

        // 加入一份牛奶
        longBlack = new Milk(longBlack);
        System.out.println("费用2="+longBlack.cost());
        System.out.println("描述2="+longBlack.getDes());

        // 加入一份巧克力
        longBlack = new Chocolate(longBlack);
        System.out.println("费用3="+longBlack.cost());
        System.out.println("描述3="+longBlack.getDes());

        // 再加入一份巧克力
        longBlack = new Chocolate(longBlack);
        System.out.println("费用4="+longBlack.cost());
        System.out.println("描述4="+longBlack.getDes());
    }
}
