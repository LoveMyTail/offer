package DesignMode.Proxy.StaticProxy;

// 代理对象，静态代理
public class TeacherDaoProxy implements ITeacherDao {

    private ITeacherDao target;

    public TeacherDaoProxy(ITeacherDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("开始代理,完成某些操作。。。。");
        target.teach();
        System.out.println("提交。。。。。");
    }
}
