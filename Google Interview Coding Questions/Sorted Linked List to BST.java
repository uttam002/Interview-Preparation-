class Solution {
    public TNode sortedListToBST(LNode head) {
        if (head == null) return null; // Base case for empty list
        if (head.next == null) return new TNode(head.data); // Single node

        // Find the middle of the linked list
        LNode mid = findMiddle(head);

        // Create the root node with the middle element
        TNode root = new TNode(mid.data);

        // Recursively construct left and right subtrees
        root.left = sortedListToBST(head); // Left subtree: head to mid-1
        root.right = sortedListToBST(mid.next); // Right subtree: mid+1 to end

        return root;
    }

    // Helper method to find the middle of the linked list
    private LNode findMiddle(LNode head) {
        LNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // Disconnect left half from the middle
        if (prev != null) prev.next = null;
        return slow;
    }
}
