class Solution {
    public String getString(String str)
    {
        int freq[] = new int[26];

        for(char c:str.toCharArray())
        {
            freq[c-'a']++;
        }
        StringBuilder strings = new StringBuilder("");
        
        char c='a';
        for(int i:freq){
            strings.append(c);
            strings.append(i);
            c++;
        }
        return strings.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str:strs)
        {
            String freqString = getString(str);

            if(map.containsKey(freqString))
            {
                map.get(freqString).add(str);
            }
            else{
                List<String> lists = new ArrayList<>();
                lists.add(str);
                map.put(freqString,lists);
            }
        }
        return new ArrayList<>(map.values());
    }
}