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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            PriorityQueue<Integer> PQ = new PriorityQueue<>();
            while (list1 != null) {
                PQ.add(list1.val);
                list1 = list1.next;
            }
            while (list2 != null) {
                PQ.add(list2.val);
                list2 = list2.next;
            }

            ListNode head = new ListNode();
            ListNode temp = head;
            while (!PQ.isEmpty()) {
                head.next = new ListNode(PQ.poll());
                head = head.next;
            }
            return temp.next;
        }
}