class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;
        
        int maxlength=0;
        int[] occurance = new int[26];
        int maxfreq=0;
        for(int r=0; r<s.length(); r++)
        {
            occurance[s.charAt(r)-'A']++;
            maxfreq = Math.max(maxfreq,occurance[s.charAt(r)-'A']);

            while((r-left+1) - maxfreq >k)
            {
                occurance[s.charAt(left)-'A']--;
                // maxfreq = Math.max(maxfreq,occurance[s.charAt(r)-'A']);
                left++;
                // maxlength=Math.max(maxlength,r-left+1);
            }
            maxlength=Math.max(maxlength,r-left+1);
        }
        return maxlength;
    }
}