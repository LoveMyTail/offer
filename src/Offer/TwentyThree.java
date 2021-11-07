package Offer;

/**
 * 链表中环的入口节点
 * 如果一个链表中包含环，如何找出环的入口节点？
 * 例如，在如下所示的链表中，环的入口节点是节点3
 * 1→2→3→4→5→3
 */
public class TwentyThree {
    public static void main(String[] args) {
        SolutionTwentyThree s = new SolutionTwentyThree();

    }
}

/**
 * 由于提前确定链表有环，所以先根据快慢指针找到快慢指针相遇的地方
 * 相遇的地方必然在环的内部，则可以让该点在环内走一圈来确定环内有几个节点
 *
 *
 */
class SolutionTwentyThree {
    public ListNode get(ListNode head) {
        if (head == null)
            return null;
        ListNode start = head;
        ListNode end = head;
        while (end != null) {
            if (start == end){
                break;
            }
            else {
                start = start.next;
                end = end.next.next;
            }
        }
        int cur = 0;
        while (start!=end){
            start = start.next;
            cur++;
        }
        // 此时已经知道环内有几个节点
        ListNode node = head;
        for (int i=0;i<cur;i++){
            node = node.next;
        }
        while (head!=node){
            head = head.next;
            node = node.next;
        }
        return head;
    }
}
