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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        if(root != null)
        q.offer(root);

        while(!q.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode dummy = q.poll();
                tmp.add(dummy.val);
                if(dummy.left != null) q.offer(dummy.left);
                if(dummy.right != null) q.offer(dummy.right);
            }
            list.add(tmp);
        }
    return list;
    }
}
