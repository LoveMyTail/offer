package LeetCode;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 示例 1:
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class Problem148 {
    public static void main(String[] args) {

    }
}

// 链表的归并排序
class SolutionProblem148 {
    public ListNode sortList(ListNode head) {
        // 如果头结点为空则直接返回
        return head == null ? null : mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head.next == null) {
            return head;
        }
        // 快慢指针找中间节点，pre为中间节点的前一个节点
        ListNode p = head, q = head, pre = null;
        while (q != null && q.next != null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        // 从中间节点的前一个位置断开，此时分为两部分
        pre.next = null;
        // 前半段和后半段递归
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(p);
        // 将前半段和后半段合并
        return merge(l, r);
    }

    ListNode merge(ListNode l, ListNode r) {
        // 构建临时节点
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l != null && r != null) {
            if (l.val <= r.val) {
                cur.next = l;
                cur = cur.next;
                l = l.next;
            } else {
                cur.next = r;
                cur = cur.next;
                r = r.next;
            }
        }
        if (l != null) {
            cur.next = l;
        }
        if (r != null) {
            cur.next = r;
        }
        return dummyHead.next;
    }
}
