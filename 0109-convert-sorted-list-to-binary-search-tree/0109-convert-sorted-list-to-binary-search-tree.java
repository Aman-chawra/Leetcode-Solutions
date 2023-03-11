/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            ++size;
        }
        return size;
    }

    private ListNode cur;

    private TreeNode toBst(int size) {
        if (size == 0) {
            return null;
        }
        TreeNode left = toBst(size / 2);
        int midVal = cur.val;
        cur = cur.next;
        TreeNode right = toBst((size - 1) / 2);
        return new TreeNode(midVal, left, right);
    }

    public TreeNode sortedListToBST(ListNode head) {
        cur = head;
        return toBst(getSize(head));
    }
}