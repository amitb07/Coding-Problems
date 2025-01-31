// 24. Swap Nodes in Pairs
// https://leetcode.com/problems/swap-nodes-in-pairs/description/
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
    // recursive solution
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        return recurse(head);
    }
    ListNode recurse(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode first = head, second=head.next, temp;
        temp = head.next.next;
        second.next = first;
        first.next = recurse(temp);
        return second;
    }
    // iterative solution
    public ListNode swapPairs2(ListNode head) {
        ListNode firstNode, secondNode, cur=head, newHead=head, nxt = null, prev=null;
        if(head!=null && head.next != null)
            newHead=head.next;
        while(cur!=null && cur.next!=null){
            firstNode = cur;
            secondNode = cur.next;
            nxt = cur.next.next;
            if(prev!=null)
                prev.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            prev = firstNode;
            cur=nxt;   
        }
        return newHead;
    }
}