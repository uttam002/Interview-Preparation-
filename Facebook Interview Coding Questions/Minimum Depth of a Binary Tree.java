class Solution {
    int minDepth(Node root) {
        // If the tree is empty, return 0
        if (root == null) {
            return 0;
        }

        // If one of the subtrees is null, we need to consider the depth of the other subtree
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        // If both subtrees are non-null, take the minimum of both depths
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
