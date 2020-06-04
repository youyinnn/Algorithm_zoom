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

    public ListNode removeNthFromEnd3(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        ListNode p1 = head, p2 = head, pre = head;
        while (p1 != null) {
            if (n != 0) {
                n--;
            } else {
                pre = p2;
                p2 = p2.next;    
            }
            p1 = p1.next;
        }
        if (p2 == head) {
            return head.next;
        }
        pre.next = p2.next;
        return head;
    }

    @Test
    public void test3(){
        removeNthFromEnd3(ListNode.arr2List(1, 2, 3, 4, 5), 1).print();
        removeNthFromEnd3(ListNode.arr2List(1, 2, 3, 4, 5), 2).print();
        removeNthFromEnd3(ListNode.arr2List(1, 2, 3, 4, 5), 3).print();
        removeNthFromEnd3(ListNode.arr2List(1, 2, 3, 4, 5), 4).print();
        removeNthFromEnd3(ListNode.arr2List(1, 2, 3, 4, 5), 5).print();
    }

    @Test
    public void test4() {
        System.out.println(removeNthFromEnd3(ListNode.arr2List(1), 1));
        System.out.println(removeNthFromEnd3(ListNode.arr2List(0), 0));
    }
}
