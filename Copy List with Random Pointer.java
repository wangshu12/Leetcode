// 1. Iterate the original list and duplicate each node. we use a hashmap to store the input nodes as ekey and its copy as value;
// 2. also, we let the random reference of each copy node points to the original input node;
// 3. finally, we iterate the copied linkedlist and use the map to update the random refence of each copy node
// 4. As a result, the space complexity of this solution is O(N), with a linear time complexity.
// !: edge case: when input is only one node.

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cursor = head;
        RandomListNode ret = null;
        RandomListNode prev = null;
        while(cursor != null){
            RandomListNode newNode = new RandomListNode(cursor.label);
            if(ret == null){
                ret = newNode;
            }else{
                prev.next = newNode;
            }
            newNode.random = cursor.random;
            map.put(cursor, newNode);
            cursor = cursor.next;
            prev = newNode;
        }
        cursor = ret;
        while(cursor != null){
            if(map.containsKey(cursor.random)){
                cursor.random = map.get(cursor.random);
            }
            cursor = cursor.next;
        }
        return ret;
    }
}

// Space: O(1)
// Time O(3n)
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        //copy node and manipulate next pointer
        // make next pointer of original node to point the copy node; make next pointer of copyt node to point original node.next
        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode cursor1 = head;
        RandomListNode cursor2 = newHead;
        while(cursor1 != null){
            cursor2.next = cursor1.next;
            cursor1.next = cursor2;
            cursor1 = cursor2.next;
            if(cursor1 != null){
                RandomListNode newNode = new RandomListNode(cursor1.label);
                cursor2 = newNode;
            }
        }
        
        // make the random pointer to point to the correct copy node
        cursor1 = head;
        cursor2 = newHead;
        while(cursor1 != null){
            if(cursor1.random != null) cursor2.random = cursor1.random.next; //!!!!check null
            cursor1 = cursor2.next;
            if(cursor1 != null )cursor2 = cursor1.next;
        }
        
        //restore original node
        cursor1 = head;
        cursor2 = newHead;
        while(cursor1 != null){
            cursor1.next = cursor2.next;
            if(cursor2.next != null) cursor2.next = cursor2.next.next; // !!!check null
            cursor1 = cursor1.next;
            cursor2 = cursor2.next;
        }
        return newHead;
    }
}
