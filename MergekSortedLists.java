// Time Complexity : O(Nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((ListNode a, ListNode b) -> a.val - b.val);
        for(int i=0;i<lists.length;i++){
            ListNode temp = lists[i];
           if(temp!=null) minHeap.add(temp);
        }
        ListNode head = null;
        ListNode traverse = null;
        while(!minHeap.isEmpty()){
            ListNode first = minHeap.poll();
            if(first.next!=null) minHeap.add(first.next);
            if(head == null){
                // traverse = new ListNode();
                head = first;
                traverse = head;
                first.next = null;
                //traverse = traverse.next;
            }else{
                traverse.next = first;
                traverse = traverse.next;
                first.next = null;
            }
        }
        if(head!= null){
            return head;
        }
        return null;
    }
}
