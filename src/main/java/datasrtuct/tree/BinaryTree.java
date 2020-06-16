package datasrtuct.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author youyinnn
 * Date 1/29/2019
 */
public class BinaryTree {

    private class Node {
        private Integer val;
        private Node left, right;

        Node(Integer val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

    public void breadthFirstTraversal(Node root) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            result.add(tmp.val);
            if (tmp.left != null) {
                q.add(tmp.left);
            }
            if (tmp.right != null) {
                q.add(tmp.right);
            }
        }
    }

    public void preOrderTraversalRecursion(Node root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preOrderTraversalRecursion(root.left);
        preOrderTraversalRecursion(root.right);
    }

    public void preOrderTraversalWithStack(Node root) {
        Stack<Node> s = new Stack<>();
        Node tmp = root;
        while (tmp != null || !s.empty()) {
            if(tmp != null) {
                s.push(tmp);
                result.add(tmp.val);
                tmp = tmp.left;
            } else {
                tmp = s.pop().right;
            }
        }
    }

    public void inOrderTraversalWithStack(Node root) {
        Stack<Node> s = new Stack<>();
        Node tmp = root;
        while (tmp != null || !s.empty()) {
            if (tmp != null) {
                s.push(tmp);
                tmp = tmp.left;
            } else {
                tmp = s.pop();
                result.add(tmp.val);
                tmp = tmp.right;
            }
        }
    }

    public void postOrderTraversalWithStack(Node root) {
        Stack<Node> s = new Stack<>();
        Node tmp = root;
        while (tmp != null || !s.empty()) {
            if (tmp != null) {
                s.push(tmp);
                // Reverse the process of pre-order
                // result is a queue
                result.addFirst(tmp.val);
                tmp = tmp.right;
            } else {
                tmp = s.pop().left;
            }
        }
    }

    private Node node(Integer val) {
        return new Node(val);
    }

    Node root;
    Deque<Integer> result = new ArrayDeque<>();

    @Before
    public void set(){
        /**
         *           1
         *       2      3
         *    4    5  @    6
         *  @  @ 7  8
         */

        root = node(1);

        root.left = node(2);
        root.right = node(3);

        root.left.left = node(4);
        root.left.right = node(5);
        root.right.right = node(6);

        root.left.right.left = node(7);
        root.right.right.left = node(8);
    }

    @Test
    public void testBFT(){
        breadthFirstTraversal(root);
    }

    @Test
    public void testDFTPreOrderRecursion(){
        preOrderTraversalRecursion(root);
    }

    @Test
    public void testDFTPreOrderWithStack(){
        preOrderTraversalWithStack(root);
    }

    @Test
    public void testDFTInOrderWithStack() {
        inOrderTraversalWithStack(root);
    }

    @Test
    public void testDFTPostOrderWithStack(){
        postOrderTraversalWithStack(root);
    }

    @After
    public void get() {
        System.out.println(result);
    }
}
