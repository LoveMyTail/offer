package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 并k个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 示例:
 * 输入:
 * [
 *  1->4->5,
 *  1->3->4,
 *  2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class Problem23 {
    public static void main(String[] args) {
        SolutionProblem23 s = new SolutionProblem23();
    }
}
class SolutionProblem23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0 || lists==null)
            return null;
        ListNode node = new ListNode(0);
        ListNode cur = node;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for (ListNode list : lists) {
            if (list==null)
                continue;
            queue.offer(list);
        }
        while (!queue.isEmpty()){
            ListNode temp = queue.poll();
            cur.next = temp;
            cur = cur.next;
            if (temp.next!=null){
                queue.offer(temp.next);
            }
        }
        return node.next;
    }
}
