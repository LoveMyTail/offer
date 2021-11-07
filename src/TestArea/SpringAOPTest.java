package TestArea;

public class SpringAOPTest {
    public static void main(String[] args) {
        //ProxyFactory proxyFactory = new ProxyFactory(new Demo());

    }
}

interface DemoInterface{
    void hello();
}

class Demo implements DemoInterface{
    @Override
    public void hello() {
        System.out.println("this demo show");
    }
}
