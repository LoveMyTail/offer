package JavaCollection.HashSet;

import java.util.HashSet;

public class PutTest {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("abc");
        set.add("abc");
        System.out.println(set);
    }
}
