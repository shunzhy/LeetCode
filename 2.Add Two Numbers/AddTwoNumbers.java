/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode first = null;
        ListNode last = null;
        while(l1 != null) {
            if (l2 != null) {
                carry = carry + l1.val + l2.val;
                l2 = l2.next;
            } else {
                carry += l1.val;
            }
            l1 = l1.next;
            ListNode newNode = new ListNode(carry % 10);
            newNode.next = null;
            if (first == null) {
                first = newNode;
                last = newNode;
            } else {
                last.next = newNode;
                last = newNode;
            }
            carry = carry / 10;
        }
        while(l2 != null) {
            carry += l2.val;
            l2 = l2.next;
            ListNode newNode = new ListNode(carry % 10);
            newNode.next = null;
            last.next = newNode;
            last = newNode;
            carry = carry / 10;
        }
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = null;
            last.next = newNode;
            last = newNode;
        }
        return first;
    }
}
