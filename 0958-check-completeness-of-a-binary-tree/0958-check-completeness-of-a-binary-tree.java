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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        boolean hasEmpty = false;

        while(!q.isEmpty())
        {
            Queue<TreeNode> subq=new LinkedList();

            while(!q.isEmpty())
            {
            TreeNode curr=q.remove();

            if(hasEmpty==true &&(curr.left!=null || curr.right!=null))
            {return false;}
            if(curr.left==null&&curr.right!=null) return false;

            if(curr.left!=null&&curr.right==null)
            { hasEmpty=true; subq.add(curr.left);}
            else if(curr.left==null&&curr.right==null)
            {   hasEmpty=true;}
            else{subq.add(curr.left); subq.add(curr.right);}
            }
            q=subq;  
        }
        return true;
    }
}