class Solution {
    public int pivotInteger(int n) {
        int ans = -1;
        int total = (n*(n+1))/2;
        for(int k=1;k<=n;k++)
        {
            int sum = (k*(k+1))/2;
            int right = total - sum +k;
            if(sum == right)
            {
                ans = k;
                break;
            }
        }
        return ans;
    }
}