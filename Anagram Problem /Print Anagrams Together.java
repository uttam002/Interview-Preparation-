
class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        List<List<String>> result = new ArrayList<>();
        List<String> t1 =new ArrayList<>(Arrays.asList(string_list));
        
        List<String> temp = new ArrayList<>();
        
        for(int i=0;i<t1.size();i++){
            if(t1.get(i).equals("uttam")) continue;
            temp.add(t1.get(i));
            for(int j=i+1;j<t1.size();j++){
                if(check(t1.get(i),t1.get(j))) {
                    temp.add(t1.get(j));
                    t1.set(j,"uttam");
                }
            }
            result.add(temp);
            temp=new ArrayList<>();
        }
        return result;
    }
    
    boolean check (String a, String b){
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
