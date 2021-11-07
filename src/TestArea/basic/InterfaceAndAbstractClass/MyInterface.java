package TestArea.basic.InterfaceAndAbstractClass;

public interface MyInterface {

    public static final int i = 1;

    default void method() {
        System.out.println("接口中的方法" + i);
    }

//    public abstract void method(int i);
}
