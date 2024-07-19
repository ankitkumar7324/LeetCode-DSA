import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int r=0;
        int maxlen=0;
        
        int n= s.length();
        Set<Character> set = new HashSet<>();
        while(r<n)
        {
            char c= s.charAt(r);
            while(set.contains(c))
            {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);
            int len=r-l+1;
            maxlen=Math.max(len,maxlen);
            
            r++;
        }
        return maxlen;

    }
}