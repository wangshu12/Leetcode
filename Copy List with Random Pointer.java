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
