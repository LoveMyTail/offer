package LeetCode;

import java.util.Stack;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。
 * 将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 */
public class Problem445 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next.next.next.next = new ListNode(9);
        ListNode l2 = new ListNode(7);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
        SolutionProblem445 s = new SolutionProblem445();
        ListNode listNode = s.addTwoNumbers(l1, l2);
        while (listNode!=null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }
}

/**
 * 不能将其直接相加为数字然后再转化为链表，因为存在溢出的问题
 *
 */
class SolutionProblem445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1!=null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2!=null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int cur = 0;
        ListNode list  = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || cur>0){
            int sum = cur;
            sum +=stack1.isEmpty()?0:stack1.pop();
            sum +=stack2.isEmpty()?0:stack2.pop();
            ListNode node = new ListNode(sum%10);
            node.next = list;
            list = node;
            cur = sum/10;
        }
        return list;

    }
}
