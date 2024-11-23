class Solution {
    public int activitySelection(List<Integer> start, List<Integer> end) {
        int n = start.size();
        
        // Pair activities with their start and end times
        int[][] activities = new int[n][2];
        for (int i = 0; i < n; i++) {
            activities[i][0] = start.get(i);
            activities[i][1] = end.get(i);
        }
        
        // Sort activities by their end time
        Arrays.sort(activities, (a, b) -> Integer.compare(a[1], b[1]));
        
        // Greedy selection of activities
        int count = 1; // Select the first activity
        int lastEndTime = activities[0][1];
        
        for (int i = 1; i < n; i++) {
            // If the current activity starts after or when the last one ends, select it
            if (activities[i][0] > lastEndTime) {
                count++;
                lastEndTime = activities[i][1];
            }
        }
        
        return count;
    }
}
