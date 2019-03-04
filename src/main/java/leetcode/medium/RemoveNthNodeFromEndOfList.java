package leetcode.medium;

import leetcode.element.ListNode;
import org.junit.Test;

/**
 * @author youyinnn
 * Date 3/4/2019
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode end = head;
        int size = 1;
        while (end.next != null) {
            end = end.next;
            size++;
        }
        int f = size - n;
        if (f == 0) {
            head = head.next;
        } else {
            end = new ListNode(0);
            end.next = head;
            while (f > 0) {
                end = end.next;
                f--;
            }
            ListNode remove = end.next;
            end.next = remove.next;
        }
        return head;
    }

    @Test
    public void test() {
        ListNode node = ListNode.arr2List(1, 2, 3, 4, 5);
        removeNthFromEnd(node, 4).print();
    }
}
