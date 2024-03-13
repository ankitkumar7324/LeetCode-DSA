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

public class Solution {
    public static boolean isSymmetric(TreeNode root) {
        // Write your code here.
        return root == null || isSymmetricHelp(root.left, root.right);
    }

    public static boolean isSymmetricHelp(TreeNode left , TreeNode right)
    {
        if(left == null || right == null)
        {
            return (left == right);
        }

        if(left.val != right.val)
        {
            return false;
        }

        return isSymmetricHelp(left.left, right.right)
        && isSymmetricHelp(left.right, right.left);
    }
}