class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        ans[0]=1;
        // prefix
        for(int i=1;i<n;i++)
        {
            ans[i] = ans[i-1] * nums[i-1];
        }
        int suffix= 1;
        for(int j=n-1;j>=0;j--)
        {
            ans[j] = suffix * ans[j];
            suffix = nums[j] * suffix;
        }
        return ans;
    }
}