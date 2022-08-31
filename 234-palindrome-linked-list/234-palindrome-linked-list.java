/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
         ListNode slow = head,fast = head,prev,temp;
         while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev = slow;
        slow = slow.next;
        prev.next = null;
        while(slow != null)
        {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        fast = head;
        slow = prev;
        while(slow != null)
        {
            if(fast.val!=slow.val)
            {
                return false;
            }
            fast = fast.next;
            slow=slow.next;
        }
        return true;
        
 */



class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next==null) return true;
    ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast= fast.next.next;
        }
        slow.next=reverse(slow.next);
        {
            slow = slow.next;
            
        }
        while(slow!=null)
        {
            if(head.val!=slow.val)
                return false;
            slow = slow.next;
            head=head.next;
        }
        return true;
        
    }
    ListNode reverse(ListNode head)
    {
        ListNode pre = null;
        ListNode next = null;
        while(head!=null)
        {
            next = head.next;
            head.next = pre;
            pre = head;
            head=next;
        }
        return pre;
    }
}




















