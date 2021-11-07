package Job.Tencent;

import java.util.Arrays;
import java.util.Scanner;

public class MainOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (i == k-1)
                continue;
            if (i == n-1)
                System.out.print(array[i]);
            else
                System.out.print(array[i]+" ");
        }

        System.out.println();

//        int[] ints = new SolutionMainOneMethodTwo().method(array, k);
//        for (int i = 0; i < ints.length; i++) {
//            if (i == ints.length - 1)
//                System.out.print(ints[i]);
//            else
//                System.out.print(ints[i] + " ");
//        }
//
//        ListNode head = new ListNode(-1);
//        ListNode node = head;
//        for (int i = 0; i < n; i++) {
//            head.next = new ListNode(sc.nextInt());
//            head = head.next;
//        }
//        ListNode listNode = new SolutionMainOne().removeKthNode(node.next, k);
//        while (listNode != null) {
//            if (listNode.next != null)
//                System.out.print(listNode.val + " ");
//            else
//                System.out.print(listNode.val);
//            listNode = listNode.next;
//        }
    }
}

class SolutionMainOneMethodTwo {
    public int[] method(int[] array, int k) {
        int len = array.length;
        if (k == len)
            return Arrays.copyOf(array, k - 1);
        if (k == 1)
            return Arrays.copyOfRange(array, 1, len);
        for (int i = k - 1; i < len - 1; i++) {
            array[i] = array[i + 1];
        }
        return Arrays.copyOfRange(array, 0, len - 1);
    }
}


class SolutionMainOne {
    public ListNode removeKthNode(ListNode head, int k) {
        if (k == 1)
            return head.next;
        ListNode cur = head;
        for (int i = 1; i < k - 1; i++) {
            cur = cur.next;
        }
        if (cur.next.next == null) {
            cur.next = null;
        } else {
            cur.next = cur.next.next;
        }
        return head;
    }

}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }
}
