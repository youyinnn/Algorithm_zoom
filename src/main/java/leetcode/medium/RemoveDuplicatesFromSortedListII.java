package leetcode.medium;

import leetcode.element.ListNode;
import org.junit.Test;

/**
 * @author youyinnn
 * Date 3/6/2019
 */
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(0), newHead = head, now;
        // remove duplicate head
        while (newHead != null &&
                newHead.next != null &&
                newHead.next.val == newHead.val) {
            newHead = getNode(newHead).next;
        }
        pre.next = newHead;
        now = newHead;
        // remove duplicate inside list
        while (now != null) {
            if (now.next != null && now.next.val == now.val) {
                now = getNode(now).next;
                pre.next = now;
            } else {
                pre = now;
                now = now.next;
            }
        }
        return newHead;
    }

    private ListNode getNode(ListNode node) {
        while (node.next != null && node.next.val == node.val) {
            node = node.next;
        }
        return node;
    }

    @Test
    public void test(){
        ListNode.print(deleteDuplicates(ListNode.arr2List()));
        ListNode.print(deleteDuplicates(ListNode.arr2List(1,1,2,2)));
        ListNode.print(deleteDuplicates(ListNode.arr2List(1,1,2,2,3,4,4,5)));
        ListNode.print(deleteDuplicates(ListNode.arr2List(1,2,3,3,4,5)));
    }

}
