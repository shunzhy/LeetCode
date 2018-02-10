/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode p = null;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (result == null) {
                    result = new ListNode(l1.val);
                    p = result;
                } else {
                    p.next = new ListNode(l1.val);
                    p = p.next;
                }
                
                l1 = l1.next;
            } else {
                if (result == null) {
                    result = new ListNode(l2.val);
                    p = result;
                } else {
                    p.next = new ListNode(l2.val);
                    p = p.next;
                }
                
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            if (result == null) {
                result = new ListNode(l1.val);
                p = result;
            } else {
                p.next = new ListNode(l1.val);
                p = p.next;
            }
            
            l1 = l1.next;
        }
        while (l2 != null) {
            if (result == null) {
                result = new ListNode(l2.val);
                p = result;
            } else {
                p.next = new ListNode(l2.val);
                p = p.next;
            }
            l2 = l2.next;
        }
        return result;
    }
}
