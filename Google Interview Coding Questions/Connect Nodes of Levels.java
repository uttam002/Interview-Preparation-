class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        
        Node currentLevelStart = root; // The first node at the current level
        
        while (currentLevelStart != null) {
            Node current = currentLevelStart; // Traverse through the current level
            Node nextLevelStart = null; // Pointer to the first node of the next level
            Node prev = null; // Pointer to the previous node at the current level
            
            // Traverse through the current level
            while (current != null) {
                // Connect the left child
                if (current.left != null) {
                    if (prev != null) prev.nextRight = current.left;
                    if (nextLevelStart == null) nextLevelStart = current.left;
                    prev = current.left;
                }
                
                // Connect the right child
                if (current.right != null) {
                    if (prev != null) prev.nextRight = current.right;
                    if (nextLevelStart == null) nextLevelStart = current.right;
                    prev = current.right;
                }
                
                current = current.nextRight; // Move to the next node at the current level
            }
            
            // Move to the first node of the next level
            currentLevelStart = nextLevelStart;
        }
        
        return root;
    }
}
