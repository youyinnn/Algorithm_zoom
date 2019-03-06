package leetcode.hard;

import leetcode.element.ListNode;
import org.junit.Test;

/**
 * The type Merge k sorted lists.
 *
 * @author youyinnn Date 3/4/2019
 */
public class MergeKSortedLists {

    /**
     * beat 5%
     *
     * @param lists the lists
     * @return the list node
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode head = null, now = null;
        while (true) {
            int select = 0;
            int nullCount = 0;
            for (int i = 1; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (lists[select] == null ||
                            lists[select].val > lists[i].val){
                        select = i;
                    }
                }
            }
            if (head == null) {
                head = lists[select];
                now = head;
            } else {
                now.next = lists[select];
                now = now.next;
            }
            if (lists[select] == null) {
                break;
            }
            lists[select] = lists[select].next;
            for (int i = 1; i < lists.length; i++) {
                if (lists[i] == null){
                    nullCount++;
                }
            }
            if (nullCount == lists.length) {
                break;
            }
        }
        return head;
    }

    private ListNode[] ls1 = new ListNode[]{
            ListNode.arr2List(1, 4, 5),
            ListNode.arr2List(1, 3, 4),
            ListNode.arr2List(2, 6)
    };

    private ListNode[] ls2 = new ListNode[]{
            ListNode.arr2List(2, 6),
            ListNode.arr2List(),
            ListNode.arr2List(1, 4, 5),
            ListNode.arr2List(),
            ListNode.arr2List(3, 3, 4),
    };

    /**
     * Test.
     */
    @Test
    public void test(){
        mergeKLists(ls1).print();
    }

    /**
     * Merge two lists list node.
     *
     * @param now1 the now 1
     * @param now2 the now 2
     * @return the list node
     */
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

    /**
     * beats 20.00%
     *
     * @param lists the lists
     * @return the list node
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode head = lists[0];
        for (int i = 1; i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }

    /**
     * Test 2.
     */
    @Test
    public void test2(){
        mergeKLists2(ls1).print();
    }


    /**
     * Beats 12.58%
     *
     * @param lists the lists
     * @return the list node
     */
    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode head = null, now = null;
        while (true) {
            insertionSortByHead(lists);
            if (lists[0] == null) {
                break;
            }
            if (head == null) {
                head = lists[0];
                now = head;
            } else {
                now.next = lists[0];
                now = now.next;
            }
            lists[0] = lists[0].next;
        }
        return head;
    }

    private void insertionSortByHead(ListNode[] lists) {
        for (int i = 1; i < lists.length; i++) {
            int j = i;
            while (j > 0 && lists[j] != null &&
                    (lists[j - 1] == null || lists[j].val < lists[j - 1].val)) {
                swap(lists, j, j - 1);
                j--;
            }
        }
    }

    private void swap(ListNode[] lists, int a, int b) {
        ListNode tmp = lists[a];
        lists[a] = lists[b];
        lists[b] = tmp;
    }

    @Test
    public void testInsertionSortByHead(){
        insertionSortByHead(ls2);
        for (ListNode node : ls2) {
            if (node != null) {
                node.print();
            } else {
                System.out.println((Object) null);
            }
        }
    }

    @Test
    public void test3(){
        mergeKLists3(ls2).print();
    }

    public ListNode mergeKLists4(ListNode[] lists) {
        return mergeSort(lists, 0, lists.length - 1);
    }

    private ListNode mergeSort(ListNode[] lists, int start, int end) {
        int length = end - start + 1;
        if (lists.length == 0) {
            return null;
        }
        if (length == 1) {
            return lists[start];
        }
        if (length == 2) {
            return mergeTwoLists(lists[start], lists[end]);
        } else {
            int mid = (length / 2) + start;
            ListNode right = mergeSort(lists, start, mid);
            ListNode left = mergeSort(lists, mid + 1, end);
            return mergeTwoLists(right, left);
        }
    }

    @Test
    public void test4(){
        mergeKLists4(ls2).print();
    }
}
