
// 817. Linked List Components
// https://leetcode.com/problems/linked-list-components/description/


import java.util.HashSet;

public class LinkedList02 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public static ListNode getList1() {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);

        l1.next = l2;
        l2.next = l3;

        return l1;
    }

    public static void main(String[] args) {
        int[] nums = {1,0};
        numComponents(getList1(), nums);
    }

    // add all nums to hashset (O(n))
    // iterate over LL, if curr in hashSet, start tracking
    // if curr not in hashSet, stop tracking
    public static int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        boolean traversingComponent = false;
        int count = 0;

        while(head!=null) {
            if (set.contains(head.val)) { // if in subset, start traversing
                traversingComponent = true;
            }
            else { // if not in subset, check if you have been traversing, if flag changes, increment the count
                if (traversingComponent) {
                    count++;
                }
                traversingComponent = false;
            }

            head = head.next;
        }
        // if last element was in subset, traversing is still true and we haven't incremented
        if (traversingComponent) {
            traversingComponent = false;
            count++;
        }
        return count;
    }

}
