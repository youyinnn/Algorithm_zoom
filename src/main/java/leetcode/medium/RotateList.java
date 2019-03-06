package leetcode.medium;

import leetcode.element.ListNode;
import org.junit.Test;

/**
 * @author youyinnn
 * Date 3/6/2019
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode newHead, tail = null;
        int length = 0;
        ListNode now = head;
        while (now != null) {
            if (now.next == null) {
                tail = now;
            }
            now = now.next;
            length++;
        }
        k %= length;
        if (k == 0) {
            return head;
        }
        int count = 0;
        ListNode pre = new ListNode(0);
        now = head;
        pre.next = head;
        while (count < length - k) {
            pre = pre.next;
            now = now.next;
            count++;
        }
        pre.next = null;
        newHead = now;
        tail.next = head;
        return newHead;
    }

    @Test
    public void test(){
        rotateRight(ListNode.arr2List(1,2,3,4,5), 3).print();
    }
}
