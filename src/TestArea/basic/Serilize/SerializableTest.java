package TestArea.basic.Serilize;

import java.io.*;

public class SerializableTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student("A", 18);
        System.out.println(student);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(student);
        Student.QQ = 4321;
        student.setAge(20);
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        Student o = (Student)objectInputStream.readObject();
        System.out.println(o);
        /**
         * 发现address(被transient)和QQ(被static)也没有被序列化，中途修改QQ的值是为了以防读者
         * 误会QQ被序列化了。因为序列化可以保存对象的状态，但是QQ的值被改变了，说明没有被序列化。
         * static成员不属于对象实例，可能被别的对象修改没办法序列化,序列化是序列对象。对于address
         * 被反序列化后由于没有对应的引用，所以为null。而且Serializable不会调用构造方法。
         */
    }
}
class Student implements Serializable{
    private String name;
    private int age;
    public static int QQ = 1234;
    private transient String address = "beijing";

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "name: " + name + "\n"
                +"age: " + age + "\n"
                +"QQ: " + QQ + "\n"
                + "address: " + address;
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

    public static int getQQ() {
        return QQ;
    }

    public static void setQQ(int QQ) {
        Student.QQ = QQ;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
