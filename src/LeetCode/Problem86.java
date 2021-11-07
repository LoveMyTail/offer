package LeetCode;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class Problem86 {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        //head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(2);
        //head.next.next.next.next = new ListNode(5);
        //head.next.next.next.next.next = new ListNode(2);
        ListNode node = new SolutionProblem86().partition(head, 2);
        System.out.println(node);
    }
}
class SolutionProblem86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;
        ListNode p1 = new ListNode(-1),p2 = new ListNode(-1);
        ListNode cur1 = p1,cur2 = p2;
        while (head!=null){
            if (head.val>=x){
                cur1.next = head;
                cur1 = cur1.next;
            }else{
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
        }
        cur1.next = null;
        cur2.next = p1.next;
        return p2.next;
    }
}
