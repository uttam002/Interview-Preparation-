class GfG
{
	public int remAnagrams(String s,String s1)
        {
         int count=0;
         int[] ch = new int[26];
         
         for(int i=0;i<s.length();i++){
             ch[s.charAt(i) - 'a']++;
         }
         for(int i=0;i<s1.length();i++){
             ch[s1.charAt(i) - 'a']--;
         }
         
         for(int i=0;i<26;i++){
             if(ch[i]!=0) count+=Math.abs(ch[i]);
         }
         
         return count;
        }
}
