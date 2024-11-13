import java.util.List;

class Solution {
    // Function to remove duplicates from the given list
    public int remove_duplicate(List<Integer> arr) {
        // Edge case: if the list has one or no elements, it's already unique
        if (arr.size() == 0) {
            return 0;
        }

        // Initialize the pointer for the last unique element found
        int i = 0;

        // Iterate from the second element to the end of the list
        for (int j = 1; j < arr.size(); j++) {
            // Only update when a new unique element is found
            if (!arr.get(j).equals(arr.get(i))) {
                i++;
                arr.set(i, arr.get(j));
            }
        }

        // i is the index of the last unique element, so the count is i + 1
        return i + 1;
    }
}
