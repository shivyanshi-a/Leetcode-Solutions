class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0); // Dummy node
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next; // Save next
            ListNode prev = dummy;

            // Find insertion position
            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }

            // Insert current
            current.next = prev.next;
            prev.next = current;

            current = nextNode;
        }

        return dummy.next;
    }
}