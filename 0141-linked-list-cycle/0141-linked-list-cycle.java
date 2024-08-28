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
        public boolean hasCycle(ListNode head) {
            HashSet<ListNode> nodes = new HashSet<>();
            if (head == null) 
                return false;
            while (head.next != null) {
                if (nodes.contains(head)) {
                    return true;
                }
                nodes.add(head);
                head = head.next;
            }
            return false;
        }
}