/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev = null;
        ListNode cursor = head;
        int count = n - m + 1;
        while(m > 1 && cursor != null){
            prev = cursor;
            cursor = cursor.next;
            m--;
        }
        ListNode next = reverseHelper(cursor, count);
        if(prev == null) return next; // be careful if prev == null
        else{
            prev.next = next;
            return head;
        }
    }
    
    private ListNode reverseHelper(ListNode head, int count){
        ListNode cursor = head;
        ListNode prev = null;
        while(cursor != null && count-- > 0){
            ListNode next = cursor.next;
            cursor.next = prev;
            prev = cursor;
            cursor = next;
        }
        head.next = cursor;
        return prev;
    }
}


// every time, we let cursor.next points to next.next node. And swap next node to prev.next
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode empty = new ListNode(0);
        empty.next = head;
        ListNode prev = empty;
        ListNode cursor = head;
        ListNode next = null;
        for(int i = 1; i < m; i++){
            if(cursor != null){
                prev = cursor;
                cursor = cursor.next;
            }
        }
        if(cursor != null) next = cursor.next;
        for(int i = m; i < n; i++){
            cursor.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = cursor.next;
        }
        return empty.next;
    }
}