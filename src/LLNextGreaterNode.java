
// https://leetcode.com/problems/next-greater-node-in-linked-list/description/
// 1019. Next Greater Node in LL

import java.util.ArrayList;
import java.util.Stack;


// https://leetcode.com/problems/next-greater-node-in-linked-list/description/

public class LLNextGreaterNode {

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
        // 2,1,5
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;

        return l1;
    }

    public static ListNode getList2() {
//        2,7,4,3,5
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(7);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        return l1;
    }

    public static ListNode getList3() {
//        1,7,5,1,9,2,5,1
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(7);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(2);
        ListNode l7 = new ListNode(5);
        ListNode l8 = new ListNode(1);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;

        return l1;
    }

    public static void main(String[] args) {
        nextLargerNodes(getList3());
    }


    /**
     * Given the head of linked list, find next greater node for each node
     *      - convert LL to an array
     *      - for each el in array, put it to Stack
     *          - if top is greater, push element to S
     *          - if top is smaller, pop all tops that are smaller (these smaller elements will be assigned current as the next greater node)
     */
    public static int[] nextLargerNodes(ListNode head) {
        // 1) convert LL to array
        ArrayList<Integer> arr = new ArrayList<>();
        while (head!=null) {
            arr.add(head.val);
            head = head.next;
        }


        int[] res = new int[arr.size()];
        Stack<Integer> S = new Stack<>();

        for (int i = 0; i < arr.size(); i++) {
            if (S.empty()) {
                S.push(i);
            }
            else {
                int current = arr.get(i);
                if (arr.get(S.peek()) > current) { // if top is greater, push onto S
                    S.push(i);
                }
                else { // if top is smaller
                    while (true) { // pop until top smaller, assign
                        if (S.empty() || arr.get(S.peek()) >= current){
                            break;
                        }
                        res[S.pop()] = current;
                    }
                    // add current to stack
                    S.push(i);
                }
            }
        }
        return res;
    }
}



