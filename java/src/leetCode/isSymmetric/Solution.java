package leetCode.isSymmetric;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }

        return findChild(root.left, root.right);
    }

    private boolean findChild(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        } else if(left != null && right == null) {
            return false;
        } else if(left == null && right != null) {
            return false;
        }

        if(left.val != right.val) {
            return false;
        } else if(!findChild(left.left, right.right)) {
            return false;
        } else if(!findChild(left.right, right.left)) {
            return false;
        }

        return true;
    }
}