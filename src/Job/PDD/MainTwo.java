package Job.PDD;

import java.util.*;

public class MainTwo {
    public static void main(String[] args) {
//        int[] arrayCur = new int[]{1, 2, 3};
//        MyObject object1 = new MyObject(arrayCur, 1);
//        MyObject object2 = new MyObject(arrayCur, 1);
//        System.out.println(object1.equals(object2));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();// 骰子的数量
        MyObject[] cur = new MyObject[N];
        for (int i = 0; i < N; i++) {
            int[] array = new int[6];
            array[0] = sc.nextInt(); //  上
            array[1] = sc.nextInt(); //  下
            array[2] = sc.nextInt(); //  左
            array[3] = sc.nextInt(); //  右
            array[4] = sc.nextInt(); //  前
            array[5] = sc.nextInt(); //  后
            cur[i] = new MyObject(array, 1);
        }
        HashMap<MyObject, Integer> map = new HashMap<>();
        for (int i = 0; i < cur.length; i++) {
            MyObject object = cur[i];
            if (map.containsKey(object)
/*                    || map.containsKey(up(object))
                    || map.containsKey(upup(object))
                    || map.containsKey(down(object))
                    || map.containsKey(left(object))
                    || map.containsKey(leftleft(object))
                    || map.containsKey(right(object))
                    || map.containsKey(fleft(object))
                    || map.containsKey(fleftleft(object))
                    || map.containsKey(fright(object))*/) {
                map.put(object, map.get(object) + 1);
            } else {
                map.put(object, 1);
            }
        }
        System.out.println(map.size());
        for (Map.Entry<MyObject, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

//    private static MyObject up(MyObject object) {
//        object.array
//        return null;
//    }

}

class MyObject {
    int[] array;
    int count;

    public MyObject(int[] array, int count) {
        this.array = array;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyObject myObject = (MyObject) o;
        return Arrays.equals(array, myObject.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }
}
