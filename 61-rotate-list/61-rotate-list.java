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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head; 
        int len=1;
        ListNode temp = head; 
        while(temp.next!=null)
        {
            len++;
            temp = temp.next;
        }
        k=len-k%len;
        temp.next = head;
        while(k-->0) temp = temp.next;
        head = temp.next;
        temp.next=null;
        return head;
//         int i=1;
//         temp=head;
//         while(i++<len-k)
//         {
//             temp = temp.next; 
     
//         }
//         // System.out.println(temp.val);

//         ListNode ans = temp.next;
//         temp.next=null;
//         return ans;
    }
}