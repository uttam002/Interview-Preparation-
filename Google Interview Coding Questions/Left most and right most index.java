class pair  {  
    long first, second;  
    public pair(long first, long second) {  
        this.first = first;  
        this.second = second;  
    }  
}

class Solution {
    
    public pair indexes(long[] v, long x) {
        // Find the leftmost index of x
        int left = findLeftmost(v, x);
        // If x is not found, return {-1, -1}
        if (left == -1) {
            return new pair(-1, -1);
        }
        // Find the rightmost index of x
        int right = findRightmost(v, x);
        
        return new pair(left, right);
    }

    private int findLeftmost(long[] v, long x) {
        int left = 0, right = v.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (v[mid] == x) {
                result = mid;  // Update result and search left
                right = mid - 1;
            } else if (v[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private int findRightmost(long[] v, long x) {
        int left = 0, right = v.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (v[mid] == x) {
                result = mid;  // Update result and search right
                left = mid + 1;
            } else if (v[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
