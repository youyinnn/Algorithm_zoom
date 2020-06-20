package datasrtuct.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import leetcode.element.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author youyinnn
 * Date 1/29/2019
 */
public class BinaryTree {

    public void breadthFirstTraversal(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode tmp = q.poll();
            result.add(tmp.val);
            if (tmp.left != null) {
                q.add(tmp.left);
            }
            if (tmp.right != null) {
                q.add(tmp.right);
            }
        }
    }

    public void preOrderTraversalRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preOrderTraversalRecursion(root.left);
        preOrderTraversalRecursion(root.right);
    }

    public void preOrderTraversalWithStack(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode tmp = s.pop();
            result.add(tmp.val);
            if (tmp.right != null) s.push(tmp.right);
            if (tmp.left  != null) s.push(tmp.left);
        }
    }

    public void inOrderTraversalWithStack(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode tmp = root;
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

    public void postOrderTraversalWithStack(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        s1.push(root);        
        while (!s1.isEmpty()) {
            TreeNode tmp = s1.pop();
            result.addFirst(tmp.val); 
            if (tmp.left  != null) s1.push(tmp.left);
            if (tmp.right != null) s1.push(tmp.right);
        }
    }

    private TreeNode node(Integer val) {
        return new TreeNode(val);
    }

    TreeNode t1;
    TreeNode t2;
    TreeNode t3;
    Deque<Integer> result = new ArrayDeque<>();


    @Before
    public void set(){
        /**
         *           1
         *       2      3
         *    4    5  @    6
         *  @  @ 7  @    8   @
         *      9 @     @ @
         *     @@
         */

        t2 = node(1);

        t2.left = node(2);
        t2.right = node(3);

        t2.left.left = node(4);
        t2.left.right = node(5);
        t2.right.right = node(6);

        t2.left.right.left = node(7);
        t2.left.right.left.left = node(9);
        t2.right.right.left = node(8);

        t1 = node(1);
        t1.left = node(2);
        t1.right = node(3);
    
        t1.left.left = node(4);
        t1.left.right = node(5);

        t3 = node(1);

        t3.left = node(2);
        t3.right = node(2);

        t3.left.left = node(2);
        t3.right.left = node(2);
    }

    @Test
    public void testBFT(){
        breadthFirstTraversal(t2);
    }

    @Test
    public void testDFTPreOrderRecursion(){
        preOrderTraversalRecursion(t2);
    }

    @Test
    public void testDFTPreOrderWithStack(){
        preOrderTraversalWithStack(t2);
    }

    @Test
    public void testDFTInOrderWithStack() {
        inOrderTraversalWithStack(t1);
    }

    @Test
    public void testDFTPostOrderWithStack(){
        postOrderTraversalWithStack(t2);
    }

    @After
    public void get() {
        System.out.println(result);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> newLevel = new LinkedList<>();
            int currentNodeLengthInThisLevel = queue.size();
            for (int i = 0; i < currentNodeLengthInThisLevel; i++) {
                TreeNode first = queue.removeFirst();
                newLevel.add(first.val);
                if (first.left != null) queue.addLast(first.left);
                if (first.right != null) queue.addLast(first.right);
            }
            ans.add(newLevel);
        }
        return ans;
    }

    public int getDepthFromTopToBottom(TreeNode root, int depth) {
        if (root == null) return depth;
        int leftDepth = getDepthFromTopToBottom(root.left, depth + 1);
        int rightDepth = getDepthFromTopToBottom(root.right, depth + 1);
        return Math.max(leftDepth, rightDepth);
    }

    public int getDepthFromBottomToTop(TreeNode root, int depth) {
        if (root == null) return depth;
        int leftDepth = getDepthFromBottomToTop(root.left, depth) + 1;
        int rightDepth = getDepthFromBottomToTop(root.right, depth) + 1;
        return Math.max(leftDepth, rightDepth);
    }


    @Test
    public void testLevelOrder() {
        System.out.println(levelOrder(t1));
    }

    @Test
    public void testDepthFromTopToBottom() {
        System.out.println(getDepthFromTopToBottom(t1, 0));
        System.out.println(getDepthFromTopToBottom(t2, 0));

        System.out.println(getDepthFromBottomToTop(t1, 0));
        System.out.println(getDepthFromBottomToTop(t2, 0));
    }

    public boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            LinkedList<Integer> floor = new LinkedList<>();
            int currentNodeLengthAtCurrentLevel = queue.size();
            for (int i = 0; i < currentNodeLengthAtCurrentLevel; i++) {
                TreeNode node = queue.removeFirst();
                if (node != null) {
                    floor.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    floor.add(null);
                }
            }
            while (floor.size() > 1) {
                Integer left = floor.removeFirst();
                Integer right = floor.removeLast();
                boolean bothNotNullAndNotEqual = (left != null && right != null) && (!left.equals(right));
                boolean oneIsNull              = (left == null && right != null) || (left != null && right == null);
                if (bothNotNullAndNotEqual || oneIsNull) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void testIsSymmetric() {
        System.out.println(isSymmetric(t1));
        System.out.println(isSymmetric(t2));
        System.out.println(isSymmetric(t3));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return depthTWithPathSum(root, 0, sum);
    }

    public boolean depthTWithPathSum(TreeNode root, int currentSum, int targetSum) {
        if (root != null && root.left == null && root.right == null) return currentSum + root.val == targetSum;
        boolean leftPathSum  = root.left  == null ? false : depthTWithPathSum(root.left,  currentSum + root.val, targetSum); 
        boolean rightPathSum = root.right == null ? false : depthTWithPathSum(root.right, currentSum + root.val, targetSum);
        return leftPathSum || rightPathSum;
    }

    @Test
    public void testHasPathSum() {
        TreeNode root = node(5);
        root.left = node(4);
        root.right = node(8);

        root.left.left = node(11);
        root.left.left.left = node(7);
        root.left.left.right = node(2);

        root.right.left = node(13);
        root.right.right = node(4);
        root.right.right.right = node(1);

        System.out.println(hasPathSum(root, 22));
        System.out.println(hasPathSum(root, 27));
        System.out.println(hasPathSum(root, 26));
        System.out.println(hasPathSum(root, 18));
        System.out.println(hasPathSum(root, 19));
    }

    @Test
    public void testHasPathSum2() {
        TreeNode root = node(1);
        root.left = node(2);
        root.left.left = node(3);
        root.left.left.left = node(4);
        root.left.left.left.left = node(5);

        System.out.println(hasPathSum(root, 6));

        System.out.println(hasPathSum(null, 6));

        System.out.println(hasPathSum(node(6), 6));
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        int length = inorder.length;
        return getTreeNode(inorder, postorder, 0, length - 1, 0, length - 1);
    }

    public TreeNode getTreeNode(int[] inorder, int[] postorder, int pstart, int pend, int istart, int iend) {
        if (istart > iend) return null;
        if (istart == iend) return new TreeNode(inorder[istart]);
        int root = postorder[pend];
        int rootIndexInInorder = findIndex(inorder, istart, iend, root);
        int leftLength   = rootIndexInInorder - istart;
        TreeNode left    = getTreeNode(inorder, postorder, 
                                                pstart, 
                                                pstart + leftLength - 1, 
                                                istart, 
                                                istart + leftLength - 1);
        TreeNode right   = getTreeNode(inorder, postorder, 
                                                pstart + leftLength, 
                                                pend - 1, 
                                                rootIndexInInorder + 1, 
                                                iend);
        TreeNode rootNode = new TreeNode(root);
        rootNode.left = left;
        rootNode.right = right;
        return rootNode;
    }

    public int findIndex(int[] arr, int as, int ae, int t) {
        for (int i = as; i <= ae; i++) {
            if (arr[i] == t) return i;
        }
        return -1;
    }

    @Test
    public void testBuildTree() {
        int[] io = {9,3,15,20,7};
        int[] po = {9,15,7,20,3};
        System.out.println(buildTree(io, po));
    }

    @Test
    public void testBuildTree2() {
        int[] io = {9,3};
        int[] po = {9,3};
        System.out.println(buildTree(io, po));
    }

}
