class Solution {
    private boolean palindrome(String s, int i, int j)
    {
        String st = s.substring(i,j);
        int x=0;
        int y=st.length()-1;
        while(x<=y)
        {
            if(st.charAt(x)!=st.charAt(y))
            {
                return false;
            }
            x++;
            y--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int maxlength=Integer.MIN_VALUE;
        int sIndex=-1;
        for(int i=0;i<s.length();i++)
        {
            for(int j=i+1;j<=s.length();j++)
            {
                if(palindrome(s,i,j))
                {
                    if(j-i>maxlength)
                    {
                        sIndex=i;
                        maxlength = (j-i);
                    }
                }
            }
        }
        return s.substring(sIndex,sIndex+maxlength);
    }
}