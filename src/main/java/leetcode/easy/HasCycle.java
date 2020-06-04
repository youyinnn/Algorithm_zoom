package leetcode.easy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import leetcode.element.ListNode;

public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode p1 = head.next, p2 = head;
        while (p1 != null && p1.next != null) {
            if (p1 == p2) return true;
            else {
                p1 = p1.next.next;
                p2 = p2.next;
            }
        }
        return false;
    }

    @Test
    public void test1() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;

        d.next = b;
        assertEquals(true, hasCycle(a));
    }

    @Test
    public void test2() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;

        d.next = a;
        assertEquals(true, hasCycle(a));
    }

    @Test
    public void test3() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;

        d.next = d;
        assertEquals(true, hasCycle(a));
    }

    @Test
    public void test4() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;

        assertEquals(false, hasCycle(a));
    }

    
    @Test
    public void test5() {
        ListNode a = new ListNode(1);

        assertEquals(false, hasCycle(a));
    }    
    
    @Test
    public void test6() {
        ListNode a = ListNode.arr2List(1,2,3,4,5);

        assertEquals(false, hasCycle(a));
    }
    
}