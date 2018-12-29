/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cursor = head;
        ListNode next = null;
        
        while(cursor != null){
            next = cursor.next;
            cursor.next = prev;
            prev = cursor;
            cursor = next;
        }
        return prev;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        return recursive(head, null);
    }
    
    private ListNode recursive(ListNode cursor, ListNode prev){
        if(cursor == null) return prev;
        ListNode next = cursor.next;
        cursor.next = prev;
        return recursive(next, cursor);
        
    }
}