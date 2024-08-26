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
            ListNode dummy = new ListNode();
            ListNode prev = dummy;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    ListNode curr = list1;
                    prev.next = curr;
                    prev = curr;
                    list1 = list1.next;
                } else {
                    ListNode curr = list2;
                    prev.next = curr;
                    prev = curr;
                    list2 = list2.next;
                }
            }
            
            while (list1 != null) {
                ListNode curr = list1;
                prev.next = curr;
                prev = curr;
                list1 = list1.next;
            }
            
            while (list2 != null) {
                ListNode curr = list2;
                prev.next = curr;
                prev = curr;
                list2 = list2.next;
            }
            return dummy.next;
        }
}