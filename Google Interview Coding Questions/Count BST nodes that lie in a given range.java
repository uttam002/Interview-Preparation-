class Node {
    int data;
    Node left, right;
    
    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {
    // Function to count number of nodes in BST that lie in the given range.
    int getCount(Node root, int l, int h) {
        // Base case: if the node is null, return 0
        if (root == null) {
            return 0;
        }
        
        // If the current node's data lies in the range, count this node
        if (root.data >= l && root.data <= h) {
            return 1 + getCount(root.left, l, h) + getCount(root.right, l, h);
        }
        // If the current node's data is less than l, check only the right subtree
        else if (root.data < l) {
            return getCount(root.right, l, h);
        }
        // If the current node's data is greater than h, check only the left subtree
        else {
            return getCount(root.left, l, h);
        }
    }
}
