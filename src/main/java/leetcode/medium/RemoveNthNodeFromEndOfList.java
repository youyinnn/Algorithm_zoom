package leetcode.medium;

import leetcode.element.ListNode;
import org.junit.Test;

/**
 * @author youyinnn
 * Date 3/4/2019
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        int size = 1;
        while (pre.next != null) {
            pre = pre.next;
            size++;
        }
        int f = size - n;
        if (f == 0) {
            head = head.next;
        } else {
            pre = new ListNode(0);
            pre.next = head;
            while (f > 0) {
                pre = pre.next;
                f--;
            }
            ListNode remove = pre.next;
            pre.next = remove.next;
        }
        return head;
    }

    @Test
    public void test() {
        ListNode node = ListNode.arr2List(1, 2, 3, 4, 5);
        removeNthFromEnd(node, 4).print();
        removeNthFromEnd(node, 2).print();
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode pre = new ListNode(0), now = head, check;
        pre.next = head;
        if (head == null) {
            return null;
        }
        while (true) {
            int count = 0;
            check = now;
            while (count < n) {
                check = check.next;
                count++;
            }
            if (check != null) {
                pre = pre.next;
                now = now.next;
            } else {
                if (pre.next == head) {
                    return head.next;
                }
                pre.next = pre.next.next;
                break;
            }
        }
        return head;
    }

    @Test
    public void test2(){
        removeNthFromEnd2(ListNode.arr2List(1, 2, 3, 4, 5), 4).print();
        removeNthFromEnd2(ListNode.arr2List(1, 2, 3, 4, 5), 2).print();
        removeNthFromEnd2(ListNode.arr2List(1, 2, 3, 4, 5), 5).print();
    }
}
