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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode second = reverse(slow);
        ListNode first = head;

        while(first != null && second != null){
            if(first.val != second.val) return false;
            first = first.next;
            second = second.next;
        }

        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode prev = null;

        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }

        return prev;
    }
}
