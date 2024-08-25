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
            ListNode i = list1;
            ListNode j = list2;
            ListNode dummy = new ListNode();
            ListNode prev = dummy;

            while (i != null && j != null) {
                ListNode curr;
                if (i.val <= j.val) {
                    curr = new ListNode(i.val);
                    i = i.next;
                }
                else {
                    curr = new ListNode(j.val);
                    j = j.next;
                }
                prev.next = curr;
                prev = curr;
            }


            while (i != null) {
                prev.next = i;
                prev = i;
                i = i.next;
            }

            while (j != null) {
                prev.next = j;
                prev = j;
                j = j.next;
            }


            return dummy.next;
        }
}