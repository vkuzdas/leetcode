public class AddTwoNumbers {

    /**
     * You are given two non-empty linked lists representing
     * two non-negative integers. The digits are stored in reverse
     * order, and each of their nodes contains a single digit.
     * Add the two numbers and return the sum as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero,
     * except the number 0 itself.
     */
     static public class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 342
    public static ListNode getList1() {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        return l1;
    }

    // 465
    public static ListNode getList2() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        return l1;
    }

    public static ListNode getList3() {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(6);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        return l1;
    }


    public static ListNode getList5() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        return l1;
    }
    public static ListNode getList4() {
        ListNode l1 = new ListNode(9);
        return l1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode res = s.addTwoNumbers(getList5(), getList2());
    }

    private static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // iterate over each LL, save the sum
            // sum the sums
            // then create third LL representing the sum



            ListNode head = null;
            ListNode prev = null;
            int carry = 0; // can be bool
            while (l1 != null || l2 != null) {
                int sum = 0;

                if(l1 != null)
                    sum += l1.val;
                if (l2 != null)
                    sum += l2.val;

                if (carry == 1) {
                   sum++;
                   carry = 0;
                }

                if (sum >= 10) {
                    carry = 1;
                    sum = sum -10;
                }

                ListNode curr = new ListNode(sum);

                if (head == null) {
                    head = curr;
                    prev = head;
                } else {
                    prev.next = curr;
                    prev = curr;
                }
                l1 = l1 != null ? l1.next : l1;
                l2 = l2 != null ? l2.next : l2;
            }

            if (carry != 0) {
                prev.next = new ListNode(1);
                carry = 0;
            }


            return head;
        }
    }
}
