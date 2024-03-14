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
 import java.util.*;
 class Pair{
    TreeNode node;
    int num;
    public Pair(TreeNode node,int num)
    {
        this.node = node;
        this.num = num;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty())
        {
            int size = q.size();
            int minnum = q.peek().num;
            int first =0;
            int last = 0;
            for(int i=0;i<size;i++)
            {
                int curr_num = q.peek().num - minnum;
                TreeNode node = q.peek().node;
                q.remove();
                if(i==0) first = curr_num;
                if(i==size-1) last = curr_num;

                if(node.left != null)
                {
                    q.add(new Pair(node.left , curr_num*2+1));
                }
                if(node.right != null)
                {
                    q.add(new Pair(node.right , curr_num*2+2));
                }

            }
            ans = Math.max(ans ,last - first +1);
        }
        return ans;
    }
}