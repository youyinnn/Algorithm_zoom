package leetcode.medium;

import org.junit.Test;

import leetcode.element.ListNode;

public class SortList {
    
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // return slow;
        ListNode mid = slow.next;
        slow.next = null;
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(mid);
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return pre.next;
    }

    @Test
    public void t1() {
        ListNode head = ListNode.arr2List(9,8,7,6,5,4,3,2,1);
        head = sortList(head);
    }
}