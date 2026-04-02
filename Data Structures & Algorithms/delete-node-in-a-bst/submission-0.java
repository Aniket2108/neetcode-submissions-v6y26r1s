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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }

        TreeNode dummy = root;

        if(root.val == key){
            return helper(root);
        }

        while(dummy!=null){
            if(dummy.val < key){
                if(dummy.right != null && dummy.right.val == key){
                    dummy.right = helper(dummy.right);
                    break;
                }
                else{
                    dummy = dummy.right;
                }
            }
            else{
                if(dummy.left != null && dummy.left.val == key){
                    dummy.left = helper(dummy.left);
                    break;
                }
                else{
                    dummy = dummy.left;
                }
            }
        }

        return root;
    }

    public TreeNode helper(TreeNode root){
        if(root.left == null){
            return root.right;
        }
        else if(root.right == null){
            return root.left;
        }
        else{
            TreeNode right = root.right;
            TreeNode left = findMostRight(root.left);
            left.right = right;
            return root.left;
        }
    }

    public TreeNode findMostRight(TreeNode root){
        if(root.right == null){
            return root;
        }
        return findMostRight(root.right);
    }
}