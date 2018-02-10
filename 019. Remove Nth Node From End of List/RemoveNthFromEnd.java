/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        // 先获取长度
        int length = 0;
        while (p.next != null) {
            p = p.next;
            length++;
        }
        // 遍历至要删除的位置
        p = head;
        for (int i = 0; i < length - n; i++) {
            p = p.next;
        }
        // 如果删除的是头结点
        if (length == n - 1) {
            head = p.next;
            p = null;
        } else if (p.next != null) {
            p.next = p.next.next;
        }  else {
            return null;
        }
        
        return head;
    }
}
