/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        //count length of ListNode
        int length = 0;
        ListNode cursor = head;
        ListNode tail = null;
        while(cursor != null){
            length++;
            tail = cursor;
            cursor = cursor.next;
            
        }
        int index = length - k % length;
        ListNode newHead = head;
        ListNode newTail = null;
        while(index > 0){
            newTail = newHead;
            newHead = newHead.next;
            index--;
        }
        if(newHead == null) return head; // !!! if new head reach to the end of the linkedlist
        
        tail.next = head;
        newTail.next = null;
        return newHead;
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        //count length of ListNode
        int length = 0;
        ListNode cursor = head;
        ListNode tail = null;
        while(cursor != null){
            length++;
            tail = cursor;
            cursor = cursor.next;
            
        }
        tail.next = head;
        int index = length - k % length;
        ListNode newTail = null;
        while(index > 0){
            newTail = head;
            head = head.next;
            index--;
        }
        newTail.next = null;
        return head;
    }
}