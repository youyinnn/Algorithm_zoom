package leetcode.medium;

import java.util.LinkedList;

import org.junit.Test;

import leetcode.element.TreeNode;

public class LowestCommonAncestor {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> ans = new LinkedList<>();
        depth(root, p, q, ans);
        return ans.getFirst();
    }

    public boolean depth(TreeNode root, TreeNode p, TreeNode q, LinkedList<TreeNode> ans) {
        if (root == null) return false;
        boolean inLeft  = depth(root.left, p, q, ans);
        boolean inRight = depth(root.right, p, q, ans);
        if (!inLeft && !inRight) return (root.val == p.val || root.val == q.val);
        else if (inLeft && inRight) ans.add(root);
        else if ((root.val == p.val || root.val == q.val) && (inLeft || inRight)) ans.add(root);
        return inLeft || inRight;
    }

    @Test
    public void test() {
        TreeNode r = new TreeNode(3);

        r.left = new TreeNode(5);
        r.right = new TreeNode(1);
        r.left.left = new TreeNode(6);
        r.left.right = new TreeNode(2);
        r.left.right.left = new TreeNode(7);
        r.left.right.right = new TreeNode(4);

        r.right = new TreeNode(1);
        r.right.left = new TreeNode(0);
        r.right.left = new TreeNode(8);

        System.out.println(lowestCommonAncestor(r, new TreeNode(5), new TreeNode(4)));
        System.out.println(lowestCommonAncestor(r, new TreeNode(6), new TreeNode(8)));
        System.out.println(lowestCommonAncestor(r, new TreeNode(7), new TreeNode(4)));
    }
    
}