class Solution {
    public ArrayList<Integer> findFibSubset(int arr[]) {
        // Create a set to store Fibonacci numbers up to the largest number in arr
        Set<Integer> fibSet = new HashSet<>();
        
        // Generate Fibonacci numbers up to the largest number in the input array
        int a = 0, b = 1;
        while (a <= 1000000) {
            fibSet.add(a);
            int temp = a + b;
            a = b;
            b = temp;
        }
        
        // Create an ArrayList to store the result
        ArrayList<Integer> result = new ArrayList<>();
        
        // Traverse the input array and collect Fibonacci numbers
        for (int num : arr) {
            if (fibSet.contains(num)) {
                result.add(num);
            }
        }
        
        return result;
    }
}
