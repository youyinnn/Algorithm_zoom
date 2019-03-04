package leetcode.medium;

import leetcode.element.ListNode;
import org.junit.Before;
import org.junit.Test;

/**
 * @author youyinnn
 * Date 2/4/2019
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1now = l1;
        ListNode l2now = l2;
        while (l1now != null) {
            int l3nowval = l1now.val + l2now.val;
            if (l3nowval >= 10) {
                l3nowval %= 10;
                if (l2now.next != null) {
                    l2now.next.val += 1;
                } else {
                    l2now.next = new ListNode(1);
                }
            }
            l2now.val = l3nowval;
            l1now = l1now.next;
            if (l2now.next != null) {
                l2now = l2now.next;
            } else {
                l2now.next = l1now;
                break;
            }
        }
        while (l2now.val >= 10) {
            l2now.val %= 10;
            if (l2now.next != null) {
                l2now.next.val += 1;
            } else {
                l2now.next = new ListNode(1);
            }
            l2now = l2now.next;
        }
        return l2;
    }

    ListNode a;
    ListNode b;

    @Before
    public void set(){
        a = getNode("52");
        b = getNode("48");
    }

    @Test
    public void testATS(){
        System.out.println(addTwoNumbers(a, b));
    }

    /**
     * can't handle big Integer
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        long a = 0, aset = 0;
        long b = 0, bset = 0;
        while (l1 != null) {
            a += recover(l1.val, aset++);
            l1 = l1.next;
        }
        while (l2 != null) {
            b += recover(l2.val, bset++);
            l2 = l2.next;
        }
        long c = a + b;
        return getNode(c + "");
    }

    private ListNode getNode(String origin) {
        if ("0".equals(origin)) {
            return new ListNode(0);
        }
        ListNode cNode = null, ct = null;
        while (!"0".equals(origin) && origin.length() > 0) {
            int num = Integer.parseInt(origin.charAt(origin.length() - 1) + "");
            origin = origin.substring(0, origin.length() - 1);
            if (cNode == null) {
                cNode = new ListNode(num);
                ct = cNode;
            } else {
                ct.next = new ListNode(num);
                ct = ct.next;
            }
        }
        return cNode;
    }

    private long recover(int num, long set) {
        return (long) (num * (Math.pow(10, set)));
    }

    @Test
    public void testATS2(){
        System.out.println(addTwoNumbers2(a, b));
    }

    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        boolean carry = false;
        ListNode ap = l1, bp = l2;
        while (ap != null || bp != null) {
            int count = carry ? 1 : 0;
            if (ap != null) {
                count += ap.val;
            }
            if (bp != null) {
                count += bp.val;
            }
            if (count >= 10) {
                count = count % 10;
                carry = true;
            } else {
                carry = false;
            }

            if (ap != null) {
                ap.val = count;
                if (ap.next == null) {
                    if (bp != null) {
                        ap.next = bp.next;
                        bp = null;
                        l2 = ap;
                    } else if (carry) {
                        ap.next = new ListNode(1);
                        carry = false;
                        break;
                    }
                }
                ap = ap.next;
            }
            if (bp != null) {
                bp = bp.next;
            }
        }
        if (carry) {
            l2.next = new ListNode(1);
        }
        return l1;
    }

    @Test
    public void testATS3(){
        System.out.println(addTwoNumbers3(b, a));
    }

}
