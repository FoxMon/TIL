package leetCode.binaryTreeLevelOrderTravel;

import java.util.*;

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
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    List<List<Integer>> results;

    public List<List<Integer>> levelOrder(TreeNode root) {
        results = new ArrayList<>();
        if(root == null) {
            return results;
        }
        find(root);
        return results;
    }

    private void find(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < count; i++) {
                TreeNode next = queue.poll();
                level.add(next.val);
                if(next.left != null) { queue.offer(next.left); }
                if(next.right != null) { queue.offer(next.right); }
            }
            results.add(level);
        }
    }
}
