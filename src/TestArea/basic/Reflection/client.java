package TestArea.basic.Reflection;

import sun.rmi.runtime.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class client {
    private final static String TAG = "peter.log.ReflectClass";

    // 创建对象
    public static void reflectNewInstance() {
        try {
            Class<?> classBook = Class.forName("com.android.peter.reflectdemo.Book");
            Object objectBook = classBook.newInstance();
            Book book = (Book) objectBook;
            book.setName("Android进阶之光");
            book.setAuthor("刘望舒");
            //Log.d(TAG,"reflectNewInstance book = " + book.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 反射私有的构造方法
    public static void reflectPrivateConstructor() {
        try {
            Class<?> classBook = Class.forName("com.android.peter.reflectdemo.Book");
            Constructor<?> declaredConstructorBook = classBook.getDeclaredConstructor(String.class, String.class);
            declaredConstructorBook.setAccessible(true);
            Object objectBook = declaredConstructorBook.newInstance("Android开发艺术探索", "任玉刚");
            Book book = (Book) objectBook;
            //Log.d(TAG,"reflectPrivateConstructor book = " + book.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 反射私有属性
    public static void reflectPrivateField() {
        try {
            Class<?> classBook = Class.forName("com.android.peter.reflectdemo.Book");
            Object objectBook = classBook.newInstance();
            Field fieldTag = classBook.getDeclaredField("TAG");
            fieldTag.setAccessible(true);
            String tag = (String) fieldTag.get(objectBook);
            //Log.d(TAG,"reflectPrivateField tag = " + tag);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 反射私有方法
    public static void reflectPrivateMethod() {
        try {
            Class<?> classBook = Class.forName("com.android.peter.reflectdemo.Book");
            Method methodBook = classBook.getDeclaredMethod("declaredMethod", int.class);
            methodBook.setAccessible(true);
            Object objectBook = classBook.newInstance();
            String string = (String) methodBook.invoke(objectBook, 0);

            //Log.d(TAG,"reflectPrivateMethod string = " + string);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Book b1 = new Book();
        Class<? extends Book> aClass1 = b1.getClass();
        System.out.println(aClass1.getName());

        Class<Book> aClass2 = Book.class;
        System.out.println(aClass2.getName());
        System.out.println(aClass1 == aClass2); // true

        try {
            Class<?> aClass3 = Class.forName("TestArea.basic.Reflection.Book");
            System.out.println(aClass3 == aClass2); // true
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Method[] methods = aClass2.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }


}
