package Offer;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class TwentyFour {
    public static void main(String[] args) {
        SolutionTwentyFour s = new SolutionTwentyFour();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode listNode = s.reverseList(head);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}

class SolutionTwentyFour {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode start = new ListNode(-1);
        while (head.next != null) {
            ListNode cur = head.next;
            head.next = start.next;
            start.next = head;
            head = cur;
        }
        head.next = start.next;
        start.next = head;
        return start.next;
    }
}
