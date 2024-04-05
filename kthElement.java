// https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1
/*
 * Problem is from GFG Medium level , (Flipkart Interview Experience Set 26) (Microsoft)
 */
class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        
        int i=n-1,j=0;
        while(i>=0 && j<m){
            if(arr1[i]>arr2[j]){
               arr1[i]=arr1[i]+arr2[j];
               arr2[j]=arr1[i]-arr2[j];
               arr1[i]=arr1[i]-arr2[j];
            }
            i--;
            j++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        if(k<=n) return arr1[k-1];
        if(k>n) return arr2[k-n-1];
        return -1;
    }
    
}
