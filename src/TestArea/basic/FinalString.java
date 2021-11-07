package TestArea.basic;

import java.lang.reflect.Field;

public class FinalString {
    public static void main(String[] args) throws Throwable {
        String str = "abcdef";
        System.out.println(str);
        modifyString(str);
        System.out.println(str);
    }

    private static void modifyString(String str) throws Throwable {
        Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);
        field.set(str,field.get("fedcba"));
    }
}
