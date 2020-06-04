package leetcode.easy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import leetcode.element.ListNode;

public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        int length = 1;
        // get length
        ListNode tmp = head;
        while (tmp.next != null) {
            length++;
            tmp = tmp.next;
        }

        // get the middle th node
        int middle = (length + 1) / 2;
        ListNode p1 = head, p2 = head;
        while (p1.next != null) {
            if (middle != 1) {
                middle--;
            } else {
                p2 = p2.next;
            }
            p1 = p1.next;
        }
        return p2;
    }

    @Test
    public void t1() {
        assertEquals("3->4->5", middleNode(ListNode.arr2List(1, 2, 3, 4, 5)).toString());
        assertEquals("4->5->6", middleNode(ListNode.arr2List(1, 2, 3, 4, 5, 6)).toString());
        assertEquals("1", middleNode(ListNode.arr2List(1)).toString());
        assertNull(middleNode(ListNode.arr2List()));
    }
}