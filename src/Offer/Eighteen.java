package Offer;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 */
public class Eighteen {
    public static void main(String[] args) {
        SolutionEighteen s = new SolutionEighteen();
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        ListNode listNode = s.deleteNode(head, 1);
        while (listNode!=null){
            System.out.print(listNode.val+" ");
            listNode = listNode.next;
        }

    }
}
class SolutionEighteen {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val)
            return head.next;
        ListNode start = head, end = head.next;
        while (end!=null && end.val!=val){
            start = end;
            end = end.next;
        }
        start.next = end.next;
        return head;
    }
}
