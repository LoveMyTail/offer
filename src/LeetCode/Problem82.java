package LeetCode;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class Problem82 {
}

class SolutionProblem82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;  // 若head为空则直接返回null
        ListNode node = new ListNode(-1);  // 建立一个虚拟头结点
        ListNode tail = node;  // 定义一个尾巴，用于尾插法。
        for (ListNode left = head, right = head; left != null; left = right) {
            // 只要r不为空并且与l的值相等则一直向后移动
            while (right != null && right.val == left.val)
                right = right.next;
            // 若长度为1，则通过尾插法加入。
            if (left.next == right) {
                tail.next = left;
                tail = left;
                // 这里记得将尾部的后面置为null，不然可能后面会带着一些其他的节点。
                tail.next = null;
            }
        }
        return node.next;
    }
}
