package leetcode.easy;

import leetcode.element.ListNode;
import org.junit.Test;

/**
 * @author youyinnn
 * Date 3/4/2019
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode now1, ListNode now2) {
        if (now1 == null || now2 == null) {
            return now1 == null ? now2 : now1;
        }
        ListNode pre = new ListNode(0);
        pre.next = now1;
        ListNode head = now1;
        while (now2 != null && now1 != null) {
            if (now2.val < now1.val) {
                pre.next = now2;
                now2 = now2.next;
                pre.next.next = now1;
                if (head == now1) {
                    head = pre.next;
                }
            }
            pre = pre.next;
            now1 = pre.next;
        }
        if (now2 != null) {
            pre.next = now2;
        }
        return head;
    }

    @Test
    public void test(){
        mergeTwoLists(ListNode.arr2List(1, 2, 4), ListNode.arr2List(1, 3, 4)).print();
    }

}
