package leetCode.binaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

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
    List<Integer> results;
    public List<Integer> rightSideView(TreeNode root) {
        results = new ArrayList<>();
        if(root == null) { return results; }
        findRightSideView(root, 0);
        return results;
    }

    private void findRightSideView(TreeNode root, int height) {
        if(height == results.size()) { results.add(root.val); }
        if(root.right != null) { findRightSideView(root.right, height + 1); }
        if(root.left != null) { findRightSideView(root.left, height + 1); }
    }
}
