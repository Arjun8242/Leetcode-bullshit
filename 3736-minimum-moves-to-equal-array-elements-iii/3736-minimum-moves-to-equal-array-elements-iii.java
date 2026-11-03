class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int target=nums[nums.length-1];
        int moves=0;

        for(int x:nums){
            moves+=target-x;
        }

        return moves;
    }
}