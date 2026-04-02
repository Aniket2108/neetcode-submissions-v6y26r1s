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

class Solution {
    int size = 0;
    public int goodNodes(TreeNode root) {
        preOrder(root,root.val);
        return size;
    }

    public void preOrder(TreeNode root,int maxVal){
        if(root == null){
            return;
        }
        if(root.val >= maxVal){
            size++;
            maxVal = root.val;
        }
        preOrder(root.left,maxVal);
        preOrder(root.right,maxVal);
    }
}
