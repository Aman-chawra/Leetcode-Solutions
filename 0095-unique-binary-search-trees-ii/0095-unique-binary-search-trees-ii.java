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
    List<TreeNode>find(int l,int r){
        List<TreeNode>list=new ArrayList<>();
        if(l>r){list.add(null);return list;}
        for(int i=l;i<=r;i++){
            List<TreeNode>left=find(l,i-1);
            List<TreeNode>right=find(i+1,r);
            for(TreeNode lef : left){
                for(TreeNode rig : right){
                   TreeNode root=new TreeNode(i,lef,rig);
                    list.add(root);
                }
            }
        }
        return list;
    }
    public List<TreeNode> generateTrees(int n) {
        return find(1,n);
    }
}