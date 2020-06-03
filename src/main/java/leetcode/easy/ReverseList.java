package leetcode.easy;

import org.junit.Test;

import leetcode.element.ListNode;

public class ReverseList {

    /**
     * TC: O(n);
     * SC: O(2n) stack and new ListNode
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode ans = new ListNode(0), tmp = new ListNode(0);
        reverse(head, tmp, ans);
        return ans.next;
    }

    public ListNode reverse(ListNode src, ListNode tmp, ListNode head) {
        if (src.next != null) {
            ListNode pre = reverse(src.next, tmp, head);
            pre.next = new ListNode(src.val);
            tmp = pre.next;
        } else {
            tmp.val = src.val;
            head.next = tmp;
        }
        return tmp;
    }

    @Test
    public void t1() {
        reverseList(ListNode.arr2List(1 ,2 ,3 ,4 ,5)).print();
        reverseList(ListNode.arr2List(0)).print();
        reverseList(ListNode.arr2List(0, 1)).print();
        System.out.println(reverseList(null));
    }


    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tmp = null, cur = head.next;
        while (head != null) {
            head.next = tmp;
            tmp = head;
            head = cur;
            if (head == null) break;
            cur = head.next;
        }
        return tmp;
    }

    @Test
    public void t2() {
        reverseList2(ListNode.arr2List(1 ,2 ,3 ,4 ,5)).print();
        reverseList2(ListNode.arr2List(0)).print();
        reverseList2(ListNode.arr2List(0, 1)).print();
        System.out.println(reverseList2(null));
    }

    public ListNode reverseList3(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    @Test
    public void t3() {
        reverseList3(ListNode.arr2List(1 ,2 ,3 ,4 ,5)).print();
        reverseList3(ListNode.arr2List(0)).print();
        reverseList3(ListNode.arr2List(0, 1)).print();
        System.out.println(reverseList3(null));
    }

    public ListNode reverseList4(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList4(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    @Test
    public void t4() {
        reverseList4(ListNode.arr2List(1 ,2 ,3 ,4 ,5)).print();
        reverseList4(ListNode.arr2List(0)).print();
        reverseList4(ListNode.arr2List(0, 1)).print();
        System.out.println(reverseList4(null));
    }
}