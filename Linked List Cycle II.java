/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode cycle = null;
        while(slow != null && fast != null){
            slow = slow.next;
            if(fast.next == null) return null;
            else fast = fast.next.next;
            if(slow == fast){
                cycle = slow;
                break;
            } 
        }
        if(cycle == null) return null;
        // Find the start of the cycle by using Floyd's algorithm.
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}