package JavaCollection.FinalTest;

import java.util.HashMap;

public class FinalTest {
    final static HashMap<String ,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        map.put("aaa",1);
        System.out.println(map.get("aaa"));
        map.put("aaa",2);
        System.out.println(map.get("aaa"));
    }
}
