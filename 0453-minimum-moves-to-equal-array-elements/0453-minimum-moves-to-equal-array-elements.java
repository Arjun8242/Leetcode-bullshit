class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int min=nums[0];
        int ans=0;

        for(int X:nums){
            ans+=X-min;
        }

        return ans;
    }
}