import java.util.*;
class Solution {
    public String minWindow(String s, String t) {
        int minlen=Integer.MAX_VALUE;
        int l=0 , r=0;
        int cnt=0;
        int sIndex = -1;
        HashMap<Character,Integer> map = new HashMap<>();
        int n=s.length();
        int m=t.length();

        for(int i=0;i<m;i++)
        {
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }

        while(r<n)
        {
            char c=s.charAt(r);
            if(map.getOrDefault(c,0)>0)
            {
                cnt++;
            }
            map.put(c,map.getOrDefault(c,0)-1);

            while(cnt==m)
            {
                if(r-l+1<minlen)
                {
                    minlen=(r-l+1);
                    sIndex=l;

                }
                char d=s.charAt(l);
                map.put(d,map.get(d)+1);
                if(map.get(d)>0)
                {
                    cnt--;
                }
                l++;

            }
            r++;
        }
        return sIndex==-1?"":s.substring(sIndex,(sIndex+minlen));
    }
}