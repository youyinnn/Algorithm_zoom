package leetcode.medium;

import leetcode.element.ListNode;
import org.junit.Test;

/**
 * @author youyinnn
 * Date 3/6/2019
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode now = pre.next;
        ListNode next = now.next;
        while (next != null) {
            pre.next = next;
            now.next = next.next;
            next.next = now;

            pre = now;
            now = pre.next;
            if (now == null) {
                break;
            }
            next = now.next;
        }
        return newHead;
    }

    @Test
    public void test(){
        swapPairs(ListNode.arr2List(1, 2, 3, 4, 5)).print();
    }

}
