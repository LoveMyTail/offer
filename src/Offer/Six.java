package Offer;

import Offer.ListNode;

import java.util.Stack;

/**
 * 从尾到头打印链表，即链表的反向打印
 */
public class Six {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode head = listNode;
        for (int i = 1; i < 5; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        method(head);
    }

    /**
     * 使用栈来实现，时间复杂度为O(n)
     * @param head
     */
    private static void method(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        int cur = 0;
        while (head!=null){
            stack.push(head);
            cur++;
            head = head.next;
        }
        int[] array = new int[cur];
        int flag = 0;
        while (!stack.empty()){
            array[flag] = stack.pop().val;
            System.out.println(stack.pop().val);
        }
    }
}

