package DesignMode.Observer.example;

// 前台作为通知者，通知观察者。这里添加adam和tom到通知列表，
// 并从通知列表中删除了adam，测试没在通知列表中的对象不会收到通知。
public class Client {

    public static void main(String[] args) {
        //前台为通知者
        Secretary secretary = new Secretary();

        StockObserver observer = new StockObserver("adam", secretary);
        NBAObserver observer2 = new NBAObserver("tom", secretary);

        //前台通知
        secretary.attach(observer);
        secretary.attach(observer2);

        //adam没被前台通知到，所以被老板抓了个现行
        secretary.detach(observer);

        //老板回来了
        secretary.setAction("小心！Boss回来了！");
        //发通知
        secretary.notifyObservers();
    }

}
