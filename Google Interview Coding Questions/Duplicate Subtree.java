//User function Template for Java

/* A Binary Tree node

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 */

class Solution {
    private static int ans = 0;
    int dupSub(Node root) {
        // code here 
        int[] ans = {0};
        HashSet<String> s = new HashSet<>();
        
        dupSubRecur(root, s, ans);
        
        return ans[0];
    }
    private static String dupSubRecur(Node root, HashSet<String> s,int[] ans) {
        
        // For null nodes,
        if (root == null) return "N";
        
        // For leaf nodes, return its value in string.
        if (root.left == null && root.right == null) {
            return String.valueOf(root.data);
        }
        
        String curr = String.valueOf(root.data);
        
        // Process the left and right subtree.
        String left = dupSubRecur(root.left, s, ans);
        String right = dupSubRecur(root.right, s, ans);
        
        // If the node is parent to 2 
        // leaf nodes, or 1 leaf node and 1 
        // null node, then concatenate the strings
        if (!left.equals("") && !right.equals("")) {
            curr += '*' + left + '*' + right;
        } else {
            return "";
        }
        
        // If this subtree string is already 
        // present in set, set ans to 1.
        if (s.contains(curr)) {
            ans[0] = 1;
        } else {
            s.add(curr);
        }
        
        return "";
    }
}
