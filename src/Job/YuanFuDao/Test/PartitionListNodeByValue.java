package Job.YuanFuDao.Test;

import LeetCode.ListNode;


/**
 * 链表：1->8->5->4->6->3->2
 * 以某个节点为分隔，要求所有比该节点小的都在该节点前，比该节点大的都在节点后但是相对位置不变如：x=4时
 * 1->3->2->4->8->5->6
 */
public class PartitionListNodeByValue {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(8);
        head.next.next = new ListNode(5);
        ListNode next = new ListNode(4);
        head.next.next.next = next;
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next = new ListNode(2);
        ListNode node = new SolutionPartitionListNodeByValue().PartitionListNodeByValue(head, next);
        System.out.println(node);
    }
}
class SolutionPartitionListNodeByValue{
    public ListNode PartitionListNodeByValue(ListNode head,ListNode node){
        ListNode p1 = new ListNode(-1),p2 = new ListNode(-1);
        ListNode cur1 = p1,cur2 = p2;
        ListNode cur = null;
        while (head!=null){
            if (head.val == node.val){
                cur = node;
            }
            else if (head.val<node.val){
                cur1.next = head;
                cur1 = cur1.next;
            }else{
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
        }
        cur1.next = null;
        cur2.next = null;
        cur1.next = cur;
        cur.next = p2.next;
        return p1.next;

    }
}
