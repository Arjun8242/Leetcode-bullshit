class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n=nums.length;
        int left=0;
        long maxsum=0;
        long currsum=0;
        HashMap<Integer, Integer> map=new HashMap<>();

        for(int right=0;right<n;right++){
            currsum+=nums[right];
            map.put(nums[right], map.getOrDefault(nums[right], 0)+1);

            if(right-left+1==k){
                if(map.size()==k) maxsum=Math.max(maxsum, currsum);
               currsum-=nums[left];
               map.put(nums[left], map.get(nums[left])-1);

               if(map.get(nums[left])==0) map.remove(nums[left]);


               left++;

            }
        }

        return maxsum;

    }
}