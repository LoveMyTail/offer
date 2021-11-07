package TestArea.basic;

public class FinalAndPrivate {
    final void method(String str){
        System.out.println(str);
    }

    private void methodTwo(String str){
        System.out.println(str);
    }

    public void methodThree(String str){
        System.out.println(str);
    }
}

class demo extends FinalAndPrivate{
    @Override
    public void methodThree(String str) {
        super.methodThree(str);
    }
}
