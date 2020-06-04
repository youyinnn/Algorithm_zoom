package offer;

import java.util.Arrays;

import org.junit.Test;

import leetcode.element.ListNode;

public class q6 {

    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        return recursion(head, 1);   
    }

    public int[] recursion(ListNode head, int count) {
        int[] ans;
        if (head.next == null) {
            ans = new int[count];
            ans[0] = head.val;
        } else {
            ans = recursion(head.next, count + 1);
            ans[ans.length - count] = head.val;
        }
        return ans;
    }

    @Test
    public void t1() {
        System.out.println(Arrays.toString(reversePrint(ListNode.arr2List(1,3,2,5))));
        System.out.println(Arrays.toString(reversePrint(ListNode.arr2List(5))));
        System.out.println(Arrays.toString(reversePrint(ListNode.arr2List())));
    }
}