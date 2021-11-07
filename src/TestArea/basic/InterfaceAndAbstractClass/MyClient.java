package TestArea.basic.InterfaceAndAbstractClass;

public class MyClient extends MyAbstractClass implements MyInterface{
    public static void main(String[] args) {
        MyClient client = new MyClient();
        int i = client.i;
        System.out.println(i);
        client.method();


    }

//    @Override
//    public void method() {
//        System.out.println(1);
//    }

//    @Override
//    public void methodTwo() {
//
//    }

//    @Override
//    public void method(int i) {
//        System.out.println(i);
//    }
}
