package DesignMode.Observer.example;

import java.util.LinkedList;
import java.util.List;

// 前台Secretary和老板Boss作为具体通知者，实现Subject接口。
// 这里只给出Secretary类的代码，Boss类与之类似。
public class Secretary implements Subject {

    //同事列表
    private List<Observer> observers = new LinkedList<>();
    private String action;

    //添加
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    //删除
    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    //通知
    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update();
        }
    }

    //前台状态
    @Override
    public String getAction() {
        return action;
    }

    @Override
    public void setAction(String action) {
        this.action = action;
    }

}
