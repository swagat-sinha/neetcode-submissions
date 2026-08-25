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
    public void reorderList(ListNode head) {
        ListNode curr = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int i = 0;
        while (curr != null) {
            map.put(i, curr);
            curr = curr.next;
            i++;
        }

        curr = head;
        int length = i;
        i = 0;
        int l = 1;
        int r = length - 1;
        ListNode current = head;
        ListNode next;
        while (l <= r) {
            current.next = map.get(r);
            r--;
            current = current.next;

            if (l <= r) {
                current.next = map.get(l);
                l++;
                current = current.next;
            }
        }
        current.next = null;
    }
}
