import java.util.HashMap;
class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])==2)
            {
                return nums[i];
            }
        }
        
        return -1;
    }
}