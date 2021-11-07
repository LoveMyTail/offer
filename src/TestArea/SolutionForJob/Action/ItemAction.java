package TestArea.SolutionForJob.Action;

import TestArea.SolutionForJob.Entity.Item;
import TestArea.SolutionForJob.Service.TestService;

import java.util.List;

public class ItemAction {
    public static void main(String[] args) {
        TestService service = new TestService();
        List<Long> list = service.initList();
        Item item = service.initItem();
        // item的id是否与list中的某个id匹配，如果匹配，则将String类型的数据转换为负数
        method(list,item);
        System.out.println(item);
    }

    private static void method(List<Long> list, Item item) {
        Long id = item.getId();
        if (list.contains(id)){
            method2(item.getClass());
            item.setPriceA(item.getPriceA().equals("0")? item.getPriceA() : "-"+item.getPriceA());
        }
    }

    private static void method2(Class item){
    }
}
