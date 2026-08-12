class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int left=0;
        int n=nums.length;
        int ans=1;
        HashMap<Integer, Integer> map=new HashMap<>();

        for(int right=0;right<n;right++){
            map.put(nums[right], map.getOrDefault(nums[right], 0)+1);

            while(map.get(nums[right])>k && left<=right){
                map.put(nums[left], map.getOrDefault(nums[left], 0)-1);
                left++;
            }

            ans=Math.max(ans, right-left+1);
        } 

        return ans;
    }
}