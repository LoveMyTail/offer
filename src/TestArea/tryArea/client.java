package TestArea.tryArea;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;

public class client {

    public static void main(String[] args) throws IOException {
/*        HashMap<People, Integer> map = new HashMap<>();
        map.put(new People("zhangsan", 16), 1);
        map.put(new People("wangwu", 17), 1);
        map.put(new People("lisi", 18), 1);
        map.put(new People("zhaoliu", 19), 1);
        People zhangsan = new People("zhangsan", 16);
        People zhangsan2 = new People("zhangsan", 16);
        System.out.println(zhangsan.hashCode());
        System.out.println(zhangsan2.hashCode());
        System.out.println(map.get(new People("zhangsan", 16)));*/

//        Object a = new String();    // 向上转型
//        String b = (String)a;       // 向下转型
        //method(1);
        Integer a = new Integer(1);
        Integer b = new Integer(1);
        int c = 1;
        System.out.println(a==b);
        System.out.println(a==c);
    }

    private static void method(int i) {
        ArrayList<String> list = new ArrayList<>();
        while (true){
            list.add(i+":");
        }
    }

    public static void copyFileUseNIO(String src, String dst) throws IOException {
        //声明源文件和目标文件
        FileInputStream fi = new FileInputStream(new File(src));
        FileOutputStream fo = new FileOutputStream(new File(dst));
        //获得传输通道channel
        FileChannel inChannel = fi.getChannel();
        FileChannel outChannel = fo.getChannel();
        //获得容器buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            //判断是否读完文件
            int eof = inChannel.read(buffer);
            if (eof == -1) {
                break;
            }
            //重设一下buffer的position=0，limit=position
            buffer.flip();
            //开始写
            outChannel.write(buffer);
            //写完要重置buffer，重设position=0,limit=capacity
            buffer.clear();
        }
        inChannel.close();
        outChannel.close();
        fi.close();
        fo.close();
    }


}

class People {
    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String name;
    int age;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        People people = (People) o;
        return age == people.age &&
                Objects.equals(name, people.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
