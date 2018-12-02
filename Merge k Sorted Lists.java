/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        return helper(lists, 0, lists.length - 1);
    }
    
    private ListNode helper(ListNode[] lists, int i, int j){
        if(i > j) return null;
        if(i == j) return lists[i];
        int mid = i + (j - i) / 2;
        ListNode l1 = helper(lists, i, mid);
        ListNode l2 = helper(lists, mid + 1, j);
        
        return merge(l1, l2);
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode ret = null;
        if(l1.val > l2.val){
            ret = l2;
            ret.next = merge(l1, l2.next);
        }else{
            ret = l1;
            ret.next = merge(l1.next, l2);
        }
        return ret;
    }
}