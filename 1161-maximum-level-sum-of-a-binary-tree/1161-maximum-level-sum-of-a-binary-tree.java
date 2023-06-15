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
	public int maxLevelSum(TreeNode root) {
		int maxLayer = 0; // layer with maximum sum
		long maxSum = Long.MIN_VALUE; // maximum level sum
		int currLayer = 0; // current layer
		long currSum; // current level sum
		int layerSize; // size of current layer

		// breadth-first search
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			// sum current layer
			currLayer++;
			currSum = 0L;
			layerSize = queue.size();
			for (int i = 0; i < layerSize; i++) {
				TreeNode node = queue.poll();
				currSum += node.val;
				// queue next layer
				if (node.left != null) queue.add(node.left);
				if (node.right != null) queue.add(node.right);
			}
			// remember layer with maximum sum;
			if (currSum > maxSum) {
				maxLayer = currLayer;
				maxSum = currSum;
			}
		}

		return maxLayer;
	}
}