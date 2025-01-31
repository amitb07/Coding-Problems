// 92. Reverse Linked List II
// https://leetcode.com/problems/reverse-linked-list-ii/description/

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode cur = head, prev=null;
        int n = right-left+1;
        while(cur!=null && left-1>0) {
            prev = cur;
            cur=cur.next; 
            left--; 
        }
        if(prev!=null)
            prev.next = reverse(cur, n);
        else
            head = reverse(head, n);
        return head;
    }
    ListNode reverse(ListNode head, int n) {
        if(n==0 || head == null)
            return head;
        ListNode cur=head, nxt, prev=null, start = head;
        while(cur!=null && n>0) {
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
            n--;
        }
        start.next = cur;
        return prev;

    }
}