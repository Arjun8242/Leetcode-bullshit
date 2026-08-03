class Solution {
    public boolean predictTheWinner(int[] nums) {
        return solve(0, nums.length-1, nums)>=0;
    }

    public int solve(int left, int right, int[] nums){

        if(left==right) return nums[left];

        int pickleft=nums[left]-solve(left+1, right, nums);

        int pickright=nums[right]-solve(left, right-1, nums);

        return Math.max(pickleft, pickright);
    }
}