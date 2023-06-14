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

    public int getMinimumDifference(TreeNode root) {

       ArrayList<Integer> list = getList(root, new ArrayList<>());
       Integer min = Integer.MAX_VALUE;


       for(Integer i: list){

           if(i == null) continue;
           Integer minAux = getMinimumDifference(i, list);

           if(minAux<min) min = minAux;

       }

       return min;

    }

    private Integer getMinimumDifference(Integer number, ArrayList<Integer> list) {

        int min = Integer.MAX_VALUE;

        for(Integer i: list){

            if(i == null || i == number) continue;
            if(Math.abs(number-i)< min) min = Math.abs(number-i);

        }

        return min;
    }


    private ArrayList<Integer> getList(TreeNode root, ArrayList<Integer> list) {

        list.add(root.val);
        if(root.left != null) getList(root.left, list);
        if(root.right != null) getList(root.right, list);
        return list;

    }
}