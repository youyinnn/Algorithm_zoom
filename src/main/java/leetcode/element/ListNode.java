package leetcode.element;

import java.util.StringJoiner;

/**
 * @author youyinnn
 * Date 3/4/2019
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode arr2List(int... arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]), now = head;
        for (int i = 1; i < arr.length; i++) {
            now.next = new ListNode(arr[i]);
            now = now.next;
        }
        return head;
    }

    public void print() {
        StringJoiner js = new StringJoiner("->");
        ListNode tmp = this;
        while (tmp != null) {
            js.add(String.valueOf(tmp.val));
            tmp = tmp.next;
        }
        System.out.println(js.toString());
    }
}
