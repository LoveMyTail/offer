package Offer;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 示例
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 */
public class TwentyFive {
    public static void main(String[] args) {
        SolutionTwentyFive s = new SolutionTwentyFive();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode listNode = s.mergeTwoLists(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
class SolutionTwentyFive {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null && l2!=null)
            return l2;
        else if (l1!=null && l2==null)
            return l1;
        else if (l1==null && l2==null)
            return null;
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l1!=null && l2!=null){
            if (l1.val<=l2.val){
                head.next = l1;
                l1 = l1.next;
                head = head.next;
            }else{
                head.next = l2;
                l2 = l2.next;
                head = head.next;
            }
        }
        if (l1==null){
            head.next = l2;
        }else{
            head.next = l1;
        }
        return cur.next;
    }
}
