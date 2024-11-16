class Solution{
    static int maxLength(String S){
        // Stack to keep track of the indices
        Stack<Integer> stack = new Stack<>();
        
        // Push -1 to handle edge case for first valid parenthesis
        stack.push(-1);
        
        int maxLength = 0;
        
        // Iterate through the string
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            
            if (ch == '(') {
                // If the character is '(', push its index onto the stack
                stack.push(i);
            } else {
                // If the character is ')', pop the top element
                stack.pop();
                
                // If the stack is empty after popping, push the current index onto the stack
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    // Calculate the length of the valid substring
                    int length = i - stack.peek();
                    maxLength = Math.max(maxLength, length);
                }
            }
        }
        
        return maxLength;
    }
}
