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
public int numComponents(ListNode head, int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
            }

            int count = 0;
            boolean inCC = false;
            boolean prevCC = false;
            while (head != null) {
                if (set.contains(head.val)) {
                    inCC = true;
                } else if (!set.contains(head.val)) {
                    inCC = false;
                    if (prevCC == true) {
                        count ++;
                    }
                }
                prevCC = inCC;
                head = head.next;
            }
            
            if (inCC) {
                count++;
            }
            return count;
        }
}