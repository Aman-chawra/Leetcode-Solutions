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
class Solution {
    public int pairSum(ListNode head) {
        ListNode temp=head;
        int ans=-1;
        List<Integer> list=new ArrayList<Integer>();
        while(temp !=null){
            list.add(temp.val);
            temp=temp.next;
        }
        int N = list.size();
        int mid = N/2;
        for(int i=0;i<mid;i++){
            ans =Math.max(ans, list.get(i)+ list.get(N-i-1));
        }
        return ans;
    }
}