package datasrtuct.tree;

/**
 * @author youyinnn
 * Date 8/21/2018
 */
public class BinarySortTree {

    private TreeNode root;
    private int nodeCount = 0;

    public void create(String preOrder){
        char[] nodes = preOrder.toCharArray();
    }

    private void preOrderCreate() {

    }

    private class TreeNode{
        private Integer val;
        private TreeNode left;
        private TreeNode right;
        TreeNode(Integer val) {
            this.val = val;
        }
    }

}
