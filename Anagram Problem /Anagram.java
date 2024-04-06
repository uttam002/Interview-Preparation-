class Solution
{    
    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a,String b)
    {
       int[] ch = new int[26];
         
         for(int i=0;i<a.length();i++){
             ch[a.charAt(i) - 'a']++;
         }
         for(int i=0;i<b.length();i++){
             ch[b.charAt(i) - 'a']--;
         }
         
         for(int i=0;i<26;i++){
             if(ch[i]!=0) return false;
         }
        return true;
    }
}
