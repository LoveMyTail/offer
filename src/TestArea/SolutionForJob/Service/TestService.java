package TestArea.SolutionForJob.Service;

import TestArea.SolutionForJob.Entity.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TestService {

    private List<Long> list = new ArrayList<>();
    private Item item = new Item();

    public  List<Long> initList(){
        list.add(123l);
        list.add(234l);
        list.add(345l);

        return list;
    }

    public Item initItem(){
        item.setId(345l);
        item.setPriceA("11111");
        item.setPriceB("22222");
        item.setPriceC("33333");
        item.setPriceD("44444");
        item.setPriceE("555555");
        item.setPriceF("666666");
        return item;
    }

}
