package leetcode.hard;

import org.junit.Test;

import leetcode.element.TreeNode;

public class RecoverFromPreorder {

    public TreeNode recoverFromPreorder(String S) {
        String[] cs = S.split("-");
        TreeNode[] level = new TreeNode[1000];
        level[1] = new TreeNode(Integer.parseInt(cs[0]));
        int levelCount = 2;
        for (int i = 1; i < cs.length; i++) {
            String current = cs[i];
            if (current.length() == 0) {
                levelCount++;
            } else {
                int upperLevel = levelCount - 1;
                TreeNode newNode = new TreeNode(Integer.parseInt(current));
                TreeNode parent = level[upperLevel];
                if (parent.left == null) {
                    parent.left = newNode;
                } else {
                    parent.right = newNode;
                }
                level[levelCount] = newNode;
                levelCount = 2;
            }
        }
        return level[1];
    }
    
    Codec codec = new Codec();
    @Test
    public void t1() {
        System.out.println(codec.serialize(recoverFromPreorder("1-2--3---4-5--6---7")));
        System.out.println(codec.serialize(recoverFromPreorder("1-2--3--4-5--6--7")));
        System.out.println(codec.serialize(recoverFromPreorder("1-401--349---90--88")));
        System.out.println(codec.serialize(recoverFromPreorder("1")));
    }
    
}