package offer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import leetcode.element.ListNode;

public class q22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p1 = head, p2 = head;
        while (p1.next != null) {
            if (k != 1) {
                k--;
            } else {
                p2 = p2.next;
            }
            p1 = p1.next;
        }
        return p2;
    }

    @Test
    public void t1() {
        assertEquals("5", getKthFromEnd(ListNode.arr2List(1, 2, 3, 4, 5), 1).toString());
        assertEquals("4->5", getKthFromEnd(ListNode.arr2List(1, 2, 3, 4, 5), 2).toString());
        assertEquals("3->4->5", getKthFromEnd(ListNode.arr2List(1, 2, 3, 4, 5), 3).toString());
        assertEquals("2->3->4->5", getKthFromEnd(ListNode.arr2List(1, 2, 3, 4, 5), 4).toString());
        assertEquals("1->2->3->4->5", getKthFromEnd(ListNode.arr2List(1, 2, 3, 4, 5), 5).toString());
    }
}