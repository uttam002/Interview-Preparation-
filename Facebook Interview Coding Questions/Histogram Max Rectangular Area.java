class Solution {
    // Function to find the largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[]) {
        int n = hist.length;
        Stack<Integer> stack = new Stack<>(); // Stack to store indices of histogram bars
        long maxArea = 0; // Initialize maxArea to 0

        int i = 0;
        while (i < n) {
            // If the current bar is taller than or equal to the bar at the stack's top
            if (stack.isEmpty() || hist[stack.peek()] <= hist[i]) {
                stack.push(i++);
            } else {
                // Calculate area with the top of the stack as the smallest bar
                int top = stack.pop();
                long height = hist[top];
                long width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
        }

        // Process remaining bars in the stack
        while (!stack.isEmpty()) {
            int top = stack.pop();
            long height = hist[top];
            long width = stack.isEmpty() ? i : i - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }

    // Driver code for testing
    public static void main(String[] args) {
        long[] hist = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(getMaxArea(hist)); // Output: 12
    }
}
