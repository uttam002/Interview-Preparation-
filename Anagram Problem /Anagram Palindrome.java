
class Sol
{
    int isPossible (String S)
    {
        int count=0;
       int[] ch = new int[26];
         
         for(int i=0;i<S.length();i++){
             ch[S.charAt(i) - 'a']++;
         }
         for(int i=0;i<26;i++){
             if(ch[i]%2==1) count++;
             if(count == 2) return 0;
         }
         return 1;
    }
}
