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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0; i< inorder.length; i++){
            map.put(inorder[i], i);
        }

        return helper(map, inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode helper(Map<Integer, Integer> map, int[] inorder, int is, int ie, int[] postorder, int ps, int pe){
        if(is > ie || ps > pe) return null;

        TreeNode root = new TreeNode(postorder[pe]);
        int inRoot = map.get(root.val);
        int numLeft = inRoot - is;

        root.left = helper(map, inorder, is, inRoot - 1, postorder, ps, ps + numLeft - 1);

        root.right = helper(map, inorder, inRoot + 1, ie, postorder, ps + numLeft, pe - 1);

        return root;
    }
}