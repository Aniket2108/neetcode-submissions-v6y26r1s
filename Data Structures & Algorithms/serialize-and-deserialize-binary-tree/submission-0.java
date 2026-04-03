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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        q.offer(root);
        while (!q.isEmpty()) {
        TreeNode node = q.poll();

        if (node == null) {
            sb.append("null,");
        } else {
            sb.append(node.val).append(",");
            q.offer(node.left);
            q.offer(node.right);
        }
    }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] arr = data.split(",");
        
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);
        int i =1;
        while(!q.isEmpty()){
            TreeNode parent = q.poll();

            if(i<arr.length && !arr[i].equals("null")){
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                parent.left = left;
                q.offer(left);
            }
            i++;
            if(i<arr.length && !arr[i].equals("null")){
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                parent.right = right;
                q.offer(right);
            }
            i++;
        }
        return root;
    }
}
