package leetcode.hard;

import leetcode.element.ListNode;
import org.junit.Test;

/**
 * @author youyinnn
 * Date 3/9/2019
 */
public class ReverseNodesInKGroup {

    class Segment {
        ListNode head;
        ListNode tail;

        Segment(ListNode head, ListNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode
                nowPre = new ListNode(0),
                tmp = head,
                newHead = null,
                nowHead, tmpPre;
        nowPre.next = tmp;

        while (tmp != null) {
            nowHead = tmp;
            tmpPre = nowPre;
            int count = 0;
            while (count < k && tmp != null) {
                tmp = tmp.next;
                tmpPre = tmpPre.next;
                count++;
            }
            if (count == k) {
                // disconnected two part
                tmpPre.next = null;
                // reverse segment
                Segment reverse = reverse(nowHead);
                if (newHead == null) {
                    newHead = reverse.head;
                }
                // reconnected part B & C
                nowHead.next = tmp;
                // reconnected part A & B
                nowPre.next = tmpPre;
                // reassign the nowPre
                nowPre = nowHead;
            }
        }
        // when k is bigger than list length then newHead will be null
        // so just return head
        return newHead == null ? head : newHead;
    }

    private Segment reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode a = head;
        ListNode b = head.next;
        if (b == null) {
            return new Segment(head, head);
        } else if (b.next == null) {
            b.next = a;
            a.next = null;
            return new Segment(b, a);
        } else {
            ListNode right = b.next;
            b.next = null;
            Segment leftSeg = reverse(a);
            Segment rightSeg = reverse(right);
            // reconnect two seg
            rightSeg.tail.next = leftSeg.head;
            // reassign seg tail cause we connect a new list after it
            rightSeg.tail = leftSeg.tail;
            return rightSeg;
        }
    }

    @Test
    public void test(){
        ListNode node = ListNode.arr2List(1, 2, 3, 4, 5);
        reverseKGroup(node, 3).print();
    }

}
