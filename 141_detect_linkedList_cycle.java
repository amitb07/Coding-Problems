// 141 detect cycle in linked list
// https://leetcode.com/problems/linked-list-cycle/

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
    // fast and slow pointer approach
    public boolean hasCycle(ListNode head) {
       ListNode slow, fast;
       slow = head; fast = head;
       while(slow!=null && fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
       } 
       return false;
    }
}