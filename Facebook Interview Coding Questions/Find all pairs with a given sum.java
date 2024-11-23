// User function Template for Java

/*
class pair  {
    long first, second;
    public pair(long first, long second)
    {
        this.first = first;
        this.second = second;
    }
}
*/

class Solution {
    public pair[] allPairs(int target, int arr1[], int arr2[]) {
        // Your code goes here
        
        Map <Integer,Integer> map1 = new HashMap<>();
        Map <Integer,Integer> map2 = new HashMap<>();
        for(int i=0;i<arr2.length;i++)
        {
            if(!map2.containsKey(arr2[i]))
                map2.put(arr2[i],1);
            else
                map2.put(arr2[i],map2.get(arr2[i])+1);
        }
        
        List<pair> ans = new ArrayList<>();
        for(int i=0;i<arr1.length;i++)
        {
            int element = target - arr1[i];
            if(map2.containsKey(element))
            {
                int count  = map2.get(element);
                pair pair1;
                pair1 = new pair(arr1[i],element);
                for (int j = 0; j < count; j++)  
                    ans.add(pair1);
            }
        }
        ans.sort(Comparator.comparingLong(a -> a.first));
        return ans.toArray(new pair[0]);
    }
}
