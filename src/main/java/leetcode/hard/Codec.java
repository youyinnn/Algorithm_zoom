package leetcode.hard;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import leetcode.element.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private static final Object NULL = null;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        LinkedList<Object> queue = new LinkedList<>();
        queue.addLast(root);
        StringBuilder sb = new StringBuilder("");
        while (!queue.isEmpty()) {
            Object tmp = queue.pollFirst();
            if (tmp == NULL) {
                sb.append("@,");
            } else {
                TreeNode node = (TreeNode) tmp;
                if (node.left != null) {
                    queue.addLast(node.left);
                } else {
                    queue.add(NULL);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                } else {
                    queue.add(NULL);
                }
                sb.append(node.val).append(',');
            }
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 1,2,3,4,5,@,6,@,@,7,@,8,@,@,@,@,@
        if (data.charAt(0) == '@') return null;
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int count = 1;
        while (!queue.isEmpty() && count < nodes.length) {
            TreeNode tmp = queue.poll();
            if (!nodes[count].equals("@")) {
                TreeNode newLeft = new TreeNode(Integer.parseInt(nodes[count]));
                tmp.left = newLeft;
                queue.addLast(newLeft);
            }
            if (!nodes[count + 1].equals("@")) {
                TreeNode newRight = new TreeNode(Integer.parseInt(nodes[count + 1]));
                tmp.right = newRight;
                queue.addLast(newRight);
            }
            count += 2;
        }
        return root;
    }

    private static TreeNode node(Integer val) {
        return new TreeNode(val);
    }

    public static void main(String[] args) {
        TreeNode root = node(1);

        root.left = node(2);
        root.right = node(3);

        root.left.left = node(4);
        root.left.right = node(5);
        root.right.right = node(6);

        root.left.right.left = node(7);
        root.right.right.left = node(8);

        Codec c = new Codec();
        String serialized = c.serialize(root);
        System.out.println(serialized);
        TreeNode deserialized = c.deserialize(serialized);
        System.out.println(c.serialize(deserialized));

    }

    Codec c;

    @Before
    public void set() {
        c = new Codec();
    }

    @Test
    public void t1() {
        System.out.println(c.serialize(c.deserialize("-1,0,1")));
        System.out.println(c.serialize(c.deserialize("-1")));
        System.out.println(c.serialize(c.deserialize("@")));
    }
}